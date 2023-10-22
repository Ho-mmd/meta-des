SUMMARY = "CircuitPython data descriptor classes to represent hardware registers on I2C and SPI devices."
AUTHOR = " <Adafruit Industries <circuitpython@adafruit.com>>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6ec69d6e9e6c85adfb7799d7f8cf044e"

SRC_URI = "git://github.com/adafruit/Adafruit_CircuitPython_Register.git;protocol=https;nobranch=1 \
"
SRCREV = "f2fe0eee14428aaff4ce24545cc99f8bd28f9486"

S = "${WORKDIR}/git"

PN = "adafruit_register"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    cp -R ${WORKDIR}/git/adafruit_register ${D}${libdir}/python3.10/site-packages/
}


FILES:${PN} = "${libdir}/python3.10/site-packages/*"
