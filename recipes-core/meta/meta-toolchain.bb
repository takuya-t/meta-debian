#
# base recipe: meta/recipes-core/meta/meta-toolchain.bb
# base branch: daisy
#

PR = "r7"

#SUMMARY = "Meta package for building a installable toolchain"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit populate_sdk

#fakeroot python do_populate_sdk_prepend() {
#    sdk_package_archs = d.getVar('SDK_PACKAGE_ARCHS', True)
#    bb.warn("sdk_package_archs is %s" % d.getVar('SDK_PACKAGE_ARCHS', True))
#    d.setVar('SDK_PACKAGE_ARCHS', sdk_package_archs + " " + "qemuarm armv5te")
#
#    bb.warn("package_archs is %s" % d.getVar('PACKAGE_ARCHS', True))
#    bb.warn("package_extra_archs is %s" % d.getVar("PACKAGE_EXTRA_ARCHS", True))
#    bb.warn("machine_arch is %s" % d.getVar("MACHINE_ARCH", True))
#    package_extra_archs = d.getVar('PACKAGE_EXTRA_ARCHS', True)
#    d.setVar('PACKAGE_EXTRA_ARCHS', package_extra_archs + " " + "x86_64-nativesdk")
#}
#
#    print "hello prepend"
#    bb.warn("hello prepend yatta")
#    
#    SUDO_EXEC=commands.getoutput("which sudo")
#    bb.warn("sudo is {}".format(SUDO_EXEC))
#    bb.warn("SUDO is {}".format(commands.getoutput("echo $SUDO")))
#    out=commands.getoutput("apt-get update")
#    bb.warn("apt-get update+++++ \n {}".format(out))
#}

#	print "hello prepend"
#	SUDO_EXEC=$(which "sudo")
#
#        if [ -z $SUDO_EXEC ]; then
#                echo "No command 'sudo' found, please install sudo first. Abort!"
#                exit 1
#        fi
#
#	bbwarn("SUDO_EXEC is ${SUDO_EXEC}")
#	$SUDO_EXEC apt-get update
#	bbwarn("SUDO_EXEC apt-get update finished")
