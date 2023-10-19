DESCRIPTION = "Auto-load scripts for Raspberry Pi 4"
LICENSE = "CLOSED"

SRC_URI = " \
    file://i2c_auto.sh \
"

do_install() {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/i2c_auto.sh ${D}${sysconfdir}/init.d/
}

inherit update-rc.d

INITSCRIPT_NAME = "i2c_auto.sh"
INITSCRIPT_PARAMS = "defaults"

FILES_${PN} += " \
    ${sysconfdir}/init.d/i2c_auto.sh \
"
