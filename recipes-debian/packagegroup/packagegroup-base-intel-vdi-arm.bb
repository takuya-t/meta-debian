SUMMARY = "Boot requirements for meta-intel-vdi"
DESCRIPTION = "The set of packages required to boot the system of meta-intel-vdi"
LICENSE = "MIT"
DPR = "0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# removed from original, meta-tzcs
# fbv
# wireless-tools
# wpa-supplicant
# wget
# twm # ${VDI_PACKAGES}
# ${FIREFOX_PACKAGES}
# acpid
# alsa-utils
# dmidecode
# indicator
# xpdf
# volume
# touch-pad-controller
# gtkpopup
# fhandler
# xf86-video-intel
# xf86-video-vesa

# unmet dependency
# xserver-xorg-extension-glx


# unknown

# needed!
# liberation-fonts
#xrandr

RDEPENDS_${PN} += " \
kernel-modules \
xserver-xorg \
xterm \
xinit \
xset \
util-linux \
liberation-fonts \
xserver-xorg-multimedia-modules \
xserver-xorg-extension-dbe \
xserver-xorg-linux-fbdevhw \
xf86-video-fbdev \
xf86-input-evdev \
xf86-input-keyboard \
xf86-input-mouse \
xbitmaps \
fluxbox \
xeyes \
"

