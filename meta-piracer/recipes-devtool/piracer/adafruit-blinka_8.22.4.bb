SUMMARY = "CircuitPython APIs for non-CircuitPython versions of Python such as CPython on Linux and MicroPython."
AUTHOR = "Adafruit Industries <circuitpython@adafruit.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fccd531dce4b989c05173925f0bbb76c"

SRC_URI = "git://github.com/adafruit/Adafruit_Blinka.git;protocol=https;nobranch=1 \
"
PN = "adafruit_blinka"

SRCREV = "234688cf57e0cfd88b768a49b57ed630a4077551" 
S = "${WORKDIR}/git"

RDEPENDS:${PN} += " glibc libgpiod"

do_delete_files() {
    rm ${S}/src/adafruit_blinka/microcontroller/bcm283x/pulseio/libgpiod_pulsein
    rm ${S}/src/adafruit_blinka/microcontroller/bcm283x/pulseio/libgpiod_pulsein.license
    rm ${S}/src/adafruit_blinka/microcontroller/amlogic/a311d/pulseio/libgpiod_pulsein
    rm ${S}/src/adafruit_blinka/microcontroller/amlogic/a311d/pulseio/libgpiod_pulsein.license
}

addtask do_delete_files after do_patch before do_configure

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    cp -R ${WORKDIR}/git/src/* ${D}${libdir}/python3.10/site-packages/
}

FILES:${PN} += "${libdir}/python3.10/site-packages/*" 
