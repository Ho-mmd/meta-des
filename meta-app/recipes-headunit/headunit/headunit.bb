DESCRIPTION = "headunit"
SECTION = "apps"
LICENSE = "CLOSED"

QT_BASE = " \
qtbase \
"

QT_PKGS = " \
qtconnectivity \
qtmultimedia \
qtwebengine \
qtnetworkauth \
"

DEPENDS = "cmake-native \
${QT_BASE} \
${QT_PKGS} \
vsomeip \
common-api-c++ \ 
common-api-c++-someip \
openssl \
"

RDEPENDS_${PN} = " \
qtquickcontrols \
qtquickcontrols2 \
qtdeclarative \
qtgraphicaleffects \
qtwebengine \
qtnetworkauth \
openssl \
"

SRC_URI = "git://github.com/SEA-ME-Team4/app-hu.git;protocol=https;nobranch=1 \
file://youtube.pem \
"
SRCREV = "3a3531b6abfde7004c1a467b7b2e503bd05eb9a5"

S = "${WORKDIR}/git"

inherit cmake_qt5

EXTRA_OECMAKE += " -DBUILD_EXE=ON \
-DBUILD_LIB=ON \ 
-DBUILD_CONF=ON \
"

do_install:append() {
    install -d ${D}${sysconfdir}/ssl/certs
    install -m 0755 ${WORKDIR}/youtube.pem ${D}${sysconfdir}/ssl/certs/
}

FILES_${PN} += "${bindir}/app-hu"
