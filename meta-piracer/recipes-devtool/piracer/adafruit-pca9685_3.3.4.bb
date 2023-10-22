SUMMARY = "CircuitPython driver for motor, stepper, and servo based on PCA9685."
AUTHOR = " <Adafruit Industries <circuitpython@adafruit.com>>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e7eb6b599fb0cfb06485c64cd4242f62"


SRC_URI = "git://github.com/adafruit/Adafruit_CircuitPython_PCA9685.git;protocol=https;nobranch=1 "

SRCREV = "1a11d746e4506ae7f2eff08f584a9d75257bbc8d"
S = "${WORKDIR}/git"

PN = "adafruit_pca9685"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    install -m 0755 ${WORKDIR}/git/adafruit_pca9685.py ${D}${libdir}/python3.10/site-packages/
}

FILES:${PN} = "${libdir}/python3.10/site-packages/adafruit_pca9685.py"
