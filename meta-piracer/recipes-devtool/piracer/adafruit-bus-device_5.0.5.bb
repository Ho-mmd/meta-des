SUMMARY = "CircuitPython bus device classes to manage bus sharing."
AUTHOR = " <Adafruit Industries <circuitpython@adafruit.com>>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6ec69d6e9e6c85adfb7799d7f8cf044e"

SRC_URI = "git://github.com/adafruit/Adafruit_CircuitPython_BusDevice.git;protocol=https;nobranch=1 \
"

PN = "adafruit_bus_device"

SRCREV = "c5583b41ba457069e4af778115748215a843e825"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    cp -R ${WORKDIR}/git/adafruit_bus_device ${D}${libdir}/python3.10/site-packages/
}

FILES:${PN} = "${libdir}/python3.10/site-packages/adafruit_bus_device/*" 
