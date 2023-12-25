SUMMARY = "Python Serial Port Extension"
AUTHOR = "Chris Liechti <cliechti@gmx.net>"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=520e45e59fc2cf94aa53850f46b86436"

SRC_URI = "git://github.com/pyserial/pyserial.git;protocol=https;nobranch=1"
SRCREV = "0e7634747568547b8a7f9fd0c48ed74f16af4b23"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    cp -R ${WORKDIR}/git/serial ${D}${libdir}/python3.10/site-packages/
}


FILES:${PN} = "${libdir}/python3.10/site-packages/*"
