DESCRIPTION = "Wi-Fi setup for Raspberry Pi 4"
LICENSE = "CLOSED"

SRC_URI = " \
    file://wpa_supplicant.conf \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/wpa_supplicant/
    install -m 0700 ${S}/wpa_supplicant.conf ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant.conf
}

FILES_${PN} += " \
    ${sysconfdir}/wpa_supplicant/wpa_supplicant.conf \
"
