FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
file://team4.bashrc \
"

do_install:append() {
    install -m 0644 ${WORKDIR}/team4.bashrc ${D}${sysconfdir}/skel/.bashrc
}

