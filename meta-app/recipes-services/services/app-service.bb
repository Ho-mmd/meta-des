LICENSE = "CLOSED"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "app.service"

SRC_URI += " \
file://app.service \
"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/app.service ${D}/${systemd_unitdir}/system
}

FILES:${PN} += "${systemd_unitdir}/system/app.service"

