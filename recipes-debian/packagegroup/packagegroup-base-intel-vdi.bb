SUMMARY = "Boot requirements for meta-intel-vdi"
DESCRIPTION = "The set of packages required to boot the system of meta-intel-vdi"
LICENSE = "MIT"
DPR = "0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# remove from original, meta-tzcs
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
# xserver-xorg-utils
# xserver-xorg-extension-dri
# xserver-xorg-extension-dri2
# xserver-xorg-extension-extmod
# xserver-xorg-extension-record
# xserver-xorg-module-libwfb
# xserver-xorg-module-exa
# xserver-xorg-linux-fbdevhw
# xf86-input-evdev
# xf86-input-synaptics
# xf86-video-intel
# xf86-video-fbdev
# xprop
# libx11
# libx11-locale
# kbd
# kbd-keymaps
# xmodmap
# bitmap
# libxinerama
# xinput
# xrandr

# unmet dependency
# xserver-xorg-extension-glx


# unknown #######

# nothing provides ######
# fbv

# needed! #######
# liberation-fonts
# xrandr
# kernel-modules (probablly)
# xserver-xorg (probablly)
# xinit
# xterm
# xset
# xsetroot 
# kernel-modules (probablly)
# util-linux (probablly)
# xserver-xorg-extension-dbe (probablly)
# xserver-xorg-module-libint10
# xf86-input-keyboard
# xf86-input-mouse (probablly)

RDEPENDS_${PN} += " \
kernel-modules \
xserver-xorg \
xinit \
xterm \
xset \
util-linux \
liberation-fonts \
xserver-xorg-multimedia-modules \
xserver-xorg-extension-dbe \
xserver-xorg-module-libint10 \
xf86-input-keyboard \
xf86-input-mouse \
xf86-video-vesa \
xbitmaps \
xf86-input-evdev \
fluxbox \
xeyes \
"

