#
# base recipe: meta/recipes-support/apr/apr_1.4.8.bb
# base branch: daisy
#

PR = "r0"

inherit debian-package

DEPENDS = "util-linux"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4dfd4cd216828c8cae5de5a12f3844c8"

BBCLASSEXTEND = "native"

SRC_URI += " \
file://configure_fixes.patch \
file://configfix.patch \
file://run-ptest \
file://upgrade-and-fix-1.5.1.patch \
"

inherit autotools-brokensep lib_package binconfig multilib_header ptest

OE_BINCONFIG_EXTRA_MANGLE = " -e 's:location=source:location=installed:'"

# Added to fix some issues with cmake. Refer to https://github.com/bmwcarit/meta-ros/issues/68#issuecomment-19896928
CACHED_CONFIGUREVARS += "apr_cv_mutex_recursive=yes"

do_configure_prepend() {
	cd ${S}
	./buildconf
}

FILES_${PN}-dev += "${libdir}/apr.exp ${datadir}/build-1/*"

#for some reason, build/libtool.m4 handled by buildconf still be overwritten
#when autoconf, so handle it again.
do_configure_append() {
	sed -i -e 's/LIBTOOL=\(.*\)top_build/LIBTOOL=\1apr_build/' ${S}/build/libtool.m4
	sed -i -e 's/LIBTOOL=\(.*\)top_build/LIBTOOL=\1apr_build/' ${S}/build/apr_rules.mk
}

do_install_append() {
	oe_multilib_header apr.h
	install -d ${D}${datadir}/apr
	cp ${S}/${HOST_SYS}-libtool ${D}${datadir}/build-1/libtool
}

SSTATE_SCAN_FILES += "apr_rules.mk libtool"

SYSROOT_PREPROCESS_FUNCS += "apr_sysroot_preprocess"

apr_sysroot_preprocess () {
	d=${SYSROOT_DESTDIR}${datadir}/apr
	install -d $d/
	cp ${S}/build/apr_rules.mk $d/
	sed -i s,apr_builddir=.*,apr_builddir=,g $d/apr_rules.mk
	sed -i s,apr_builders=.*,apr_builders=,g $d/apr_rules.mk
	sed -i s,LIBTOOL=.*,LIBTOOL=${HOST_SYS}-libtool,g $d/apr_rules.mk
	sed -i s,\$\(apr_builders\),${STAGING_DATADIR}/apr/,g $d/apr_rules.mk
	cp ${S}/build/mkdir.sh $d/
	cp ${S}/build/make_exports.awk $d/
	cp ${S}/build/make_var_export.awk $d/
}

do_compile_ptest() {
        cd ${S}/test
        oe_runmake
}

do_install_ptest() {
        t=${D}${PTEST_PATH}/test
        mkdir -p $t/.libs
        cp -r ${S}/test/data $t/
        cp -r ${S}/test/.libs/*.so $t/.libs/
        cp ${S}/test/proc_child $t/
        cp ${S}/test/readchild $t/
        cp ${S}/test/sockchild $t/
        cp ${S}/test/sockperf $t/
        cp ${S}/test/testall $t/
        cp ${S}/test/tryread $t/
}
