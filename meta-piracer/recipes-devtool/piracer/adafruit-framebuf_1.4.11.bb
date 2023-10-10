SUMMARY = "CircuitPython frambuf module, based on the Python frambuf module."
AUTHOR = " <Adafruit Industries <circuitpython@adafruit.com>>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6ad4a8854b39ad474755ef1aea813bac"

SRC_URI = "git://github.com/adafruit/Adafruit_CircuitPython_framebuf.git;protocol=https;nobranch=1 "

SRCREV = "aa5ea252a2398fbd6454d5f926f33ad7b20b0645"
S = "${WORKDIR}/git"

PN = "adafruit_framebuf"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    install -m 0755 ${WORKDIR}/git/adafruit_framebuf.py ${D}${libdir}/python3.10/site-packages/
}

FILES:${PN} += "${libdir}/python3.10/site-packages/adafruit_framebuf.py"
