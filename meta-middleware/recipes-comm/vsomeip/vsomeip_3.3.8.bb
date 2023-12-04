SUMMARY = "the implementation of SOME/IP"
SECTION = "base"
LICENSE = "MPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9741c346eef56131163e13b9db1241b3"

DEPENDS = "boost dlt-daemon"

SRC_URI = "git://github.com/GENIVI/${BPN}.git;protocol=https;nobranch=1 \
"

SRCREV = "07464840f503670bc75997b8e926b54734ffa410"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

PACKAGES:remove = "${PN}-bin"
FILES:${PN} += "${bindir}/vsomeipd ${sysconfdir}/${BPN}"
FILES:${PN}-dev += "${libdir}/cmake"

BBCLASSEXTEND = "nativesdk"

EXTRA_OECMAKE += "-DENABLE_SIGNAL_HANDLING=1 \
-DDIAGNOSIS_ADDRESS=0x10 \
"

do_install:append() {
    mv ${D}/usr/etc ${D}
    rm -rf ${D}/etc/vsomeip/*
}
