SUMMARY = "Types needed for type annotation that are not in `typing`"
AUTHOR = " <Adafruit Industries <circuitpython@adafruit.com>>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a089cc2176ad7f6066833cbef57695b0"

SRC_URI = "git://github.com/adafruit/Adafruit_CircuitPython_Typing.git;protocol=https;nobranch=1"
SRCREV = "f6e60bddbf853acd367e2abd77d3253a38af0189"

S = "${WORKDIR}/git"

PN = "circuitpython_typing"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    cp -R ${WORKDIR}/git/circuitpython_typing ${D}${libdir}/python3.10/site-packages/
}


FILES:${PN} += "${libdir}/python3.10/site-packages/*"
