#
# fontconfig_2.11.0.bb
#
SUMMARY = "Generic font configuration library"
DESCRIPTION = "Fontconfig is a font configuration and customization library, which \
does not depend on the X Window System. It is designed to locate \
fonts within the system and select them according to requirements \
specified by applications. \
Fontconfig is not a rasterization library, nor does it impose a \
particular rasterization library on the application. The X-specific \
library 'Xft' uses fontconfig along with freetype to specify and \
rasterize fonts."

HOMEPAGE = "http://www.fontconfig.org"
BUGTRACKER = "https://bugs.freedesktop.org/enter_bug.cgi?product=fontconfig"

LICENSE = "MIT-style & MIT & PD"
LIC_FILES_CHKSUM = "file://COPYING;md5=7a0449e9bc5370402a94c00204beca3d \
                    file://src/fcfreetype.c;endline=45;md5=5d9513e3196a1fbfdfa94051c09dfc84 \
                    file://src/fccache.c;beginline=1131;endline=1146;md5=754c7b855210ee746e5f0b840fad9a9f"

SECTION = "libs"

DEPENDS = "expat freetype zlib"

SRC_URI = "http://fontconfig.org/release/fontconfig-${PV}.tar.gz \
           file://sysroot-arg.patch"
SRC_URI[md5sum] = "84278204cd7f36adbea7ad8094e039ac"
SRC_URI[sha256sum] = "274c047487b90dacbaa55f4d70b8cdcd556944e7251ce9cf1de442c00a16343b"

PACKAGES =+ "fontconfig-utils"
FILES_${PN} =+ "${datadir}/xml/*"
FILES_fontconfig-utils = "${bindir}/*"

# Work around past breakage in debian.bbclass
RPROVIDES_fontconfig-utils = "libfontconfig-utils"
RREPLACES_fontconfig-utils = "libfontconfig-utils"
RCONFLICTS_fontconfig-utils = "libfontconfig-utils"
DEBIAN_NOAUTONAME_fontconfig-utils = "1"

inherit autotools pkgconfig

EXTRA_OECONF = " --disable-docs --with-default-fonts=${datadir}/fonts"

BBCLASSEXTEND = "native"

#
# debian
#
inherit debian-package
DEBIAN_SECTION = "fonts"
DPR = "0"

SRC_URI += " \
	file://sysroot-arg.patch \
"
