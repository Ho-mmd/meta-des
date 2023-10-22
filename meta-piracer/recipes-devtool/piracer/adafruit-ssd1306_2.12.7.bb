SUMMARY = "CircuitPython library for SSD1306 OLED displays."
AUTHOR = " <Adafruit Industries <circuitpython@adafruit.com>>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=df3400dd14c520e98b9192195e8b82bb"

SRC_URI = "git://github.com/adafruit/Adafruit_CircuitPython_SSD1306.git;protocol=https;nobranch=1"
SRCREV = "e17c9d5c5d732b66f0523677f041a8e0f1d4bad3"

S = "${WORKDIR}/git"

PN = "adafruit_ssd1306"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    install -m 0755 ${WORKDIR}/git/adafruit_ssd1306.py ${D}${libdir}/python3.10/site-packages/
}

FILES:${PN} = "${libdir}/python3.10/site-packages/adafruit_ssd1306.py"
