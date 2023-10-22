SUMMARY = "A requests-like library for web interfacing"
HOMEPAGE = ""
AUTHOR = " <Adafruit Industries <circuitpython@adafruit.com>>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=66e022c238fbc8444a4a5166aed6ccb2"

SRC_URI = "git://github.com/adafruit/Adafruit_CircuitPython_Requests.git;protocol=https;nobranch=1"
SRCREV = "6b72737d12922d8e40260e49d3519db81db7d003"

S = "${WORKDIR}/git"

PN = "adafruit_requests"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    install -m 0755 ${WORKDIR}/git/adafruit_requests.py ${D}${libdir}/python3.10/site-packages/
}

FILES:${PN} = "${libdir}/python3.10/site-packages/adafruit_requests.py"
