SUMMARY = "Python USB access module"
HOMEPAGE = "https://pyusb.github.io/pyusb"
AUTHOR = "Jonas Malaco <me@jonasmalaco.com>"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e64a29fcd3c3dd356a24e235dfcb3905"

SRC_URI = "git://github.com/pyusb/pyusb.git;protocol=https;nobranch=1"
SRCREV = "7f3638b7c296ac8153bbff369f8a7c0e28907153"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    cp -R ${WORKDIR}/git/usb ${D}${libdir}/python3.10/site-packages/
}


FILES:${PN} = "${libdir}/python3.10/site-packages/*"
