#
# libsm_1.2.2.bb
#
SUMMARY = "SM: Session Management library"

DESCRIPTION = "The Session Management Library (SMlib) is a low-level \"C\" \
language interface to XSMP.  The purpose of the X Session Management \
Protocol (XSMP) is to provide a uniform mechanism for users to save and \
restore their sessions.  A session is a group of clients, each of which \
has a particular state."

require xorg-lib-common.inc

LICENSE = "MIT-style"
LIC_FILES_CHKSUM = "file://COPYING;md5=c0fb37f44e02bdbde80546024400728d"

DEPENDS += "libice xproto xtrans e2fsprogs"

PE = "1"

XORG_PN = "libSM"

BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "499a7773c65aba513609fe651853c5f3"
SRC_URI[sha256sum] = "0baca8c9f5d934450a70896c4ad38d06475521255ca63b717a6510fdb6e287bd"

#
# debian
#
inherit debian-package
DEBIAN_SECTION = "x11"
DPR = "0"

# There is no debian patch
DEBIAN_PATCH_TYPE = "nopatch"
