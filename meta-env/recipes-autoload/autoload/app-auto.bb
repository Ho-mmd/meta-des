DESCRIPTION = "Auto-load scripts for Raspberry Pi 4"
LICENSE = "CLOSED"

SRC_URI = " \
    file://app_auto \
"

do_install() {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/app_auto ${D}${sysconfdir}/init.d/
}

inherit update-rc.d

INITSCRIPT_NAME = "app_auto"
INITSCRIPT_PARAMS = "start 99 5 . stop 20 0 1 6 ."

FILES_${PN} += " \
    ${sysconfdir}/init.d/app_auto \
"

