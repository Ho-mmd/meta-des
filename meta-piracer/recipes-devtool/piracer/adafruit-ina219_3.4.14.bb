SUMMARY = "CircuitPython library for INA219 high side DC current sensor."
HOMEPAGE = ""
AUTHOR = " <Adafruit Industries <circuitpython@adafruit.com>>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b49eaaf85ddbd7a185408c1bea270264"

SRC_URI = "git://github.com/adafruit/Adafruit_CircuitPython_INA219.git;protocol=https;nobranch=1 "

SRCREV = "53f239d9dea9a206e593170fe2a209170fe0670a"
S = "${WORKDIR}/git"

PN = "adafruit_ina219"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    install -m 0755 ${WORKDIR}/git/adafruit_ina219.py ${D}${libdir}/python3.10/site-packages/
}

FILES:${PN} += "${libdir}/python3.10/site-packages/adafruit_ina219.py"
