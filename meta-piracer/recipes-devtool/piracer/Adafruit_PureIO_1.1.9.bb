SUMMARY = "Pure python (i.e. no native extensions) access to Linux IO    including I2C and SPI. Drop in replacement for smbus and spidev modules."
AUTHOR = " <Adafruit Industries <circuitpython@adafruit.com>>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a21fcca821a506d4c36f7bbecc0d009"

SRC_URI = "git://github.com/adafruit/Adafruit_Python_PureIO.git;protocol=https;nobranch=1 \
"
SRCREV = "383b615ce9ff5bbefdf77652799f380016fda353"

S = "${WORKDIR}/git"

PN = "Adafruit_PureIO"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    cp -R ${WORKDIR}/git/Adafruit_PureIO ${D}${libdir}/python3.10/site-packages/
}


FILES:${PN} += "${libdir}/python3.10/site-packages/*"
