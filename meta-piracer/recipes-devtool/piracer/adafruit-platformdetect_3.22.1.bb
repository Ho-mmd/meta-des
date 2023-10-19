SUMMARY = "Platform detection for use by libraries like Adafruit-Blinka."
AUTHOR = " <Adafruit Industries <circuitpython@adafruit.com>>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fccd531dce4b989c05173925f0bbb76c"

SRC_URI = "git://github.com/adafruit/Adafruit_Python_PlatformDetect.git;protocol=https;nobranch=1 \
"
SRCREV = "7af3af87037cf1e6697471a3a83c56a0f852b959"

S = "${WORKDIR}/git"

PN = "adafruit_platformdetect"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    cp -R ${WORKDIR}/git/adafruit_platformdetect ${D}${libdir}/python3.10/site-packages/
}


FILES:${PN} += "${libdir}/python3.10/site-packages/*"
