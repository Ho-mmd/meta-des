DESCRIPTION = "Auto-load scripts for Raspberry Pi 4"
LICENSE = "CLOSED"

SRC_URI = " \
    file://wifi_auto.sh \
"

do_install() {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/wifi_auto.sh ${D}${sysconfdir}/init.d/
}

inherit update-rc.d

INITSCRIPT_NAME = "wifi_auto.sh"
INITSCRIPT_PARAMS = "defaults"

FILES_${PN} += " \
    ${sysconfdir}/init.d/wifi_auto.sh \
"
