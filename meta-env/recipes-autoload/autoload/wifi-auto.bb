DESCRIPTION = "Auto-load scripts for Raspberry Pi 4"
LICENSE = "CLOSED"

SRC_URI = " \
    file://wifi_auto \
"

do_install() {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/wifi_auto ${D}${sysconfdir}/init.d/
}

inherit update-rc.d

INITSCRIPT_NAME = "wifi_auto"
INITSCRIPT_PARAMS = "start 97 5 . stop 20 0 1 6 ."

FILES_${PN} += " \
    ${sysconfdir}/init.d/wifi_auto \
"
