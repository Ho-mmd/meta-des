SUMMARY = "FTDI device driver (pure Python)"
AUTHOR = "Emmanuel Blot <emmanuel.blot@free.fr>"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=895c052d67dfd1e38522804c6e9048ba"

SRC_URI = "git://github.com/eblot/pyftdi.git;protocol=https;nobranch=1"
SRCREV = "800fccb21b80ce427a61f264174e48563c21e3de"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    cp -R ${WORKDIR}/git/pyftdi ${D}${libdir}/python3.10/site-packages/
}


FILES:${PN} += "${libdir}/python3.10/site-packages/*"
