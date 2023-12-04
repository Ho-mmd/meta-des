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
qtquickcontrols \
qtquickcontrols2 \
qtdeclarative \
qtgraphicaleffects \
qtvirtualkeyboard \
"

Connect_PKGS = " \
vsomeip \
common-api-c++ \ 
common-api-c++-someip \
openssl \
"

DEPENDS = "cmake-native \
${QT_BASE} \
${QT_PKGS} \
${Connect_PKGS} \
"

RDEPENDS:${PN} = " \
${QT_PKGS} \
${Connect_PKGS} \
"

SRC_URI = "git://github.com/SEA-ME-Team4/app-des.git;protocol=https;nobranch=1 \
file://youtube.pem \
"
SRCREV = "540cff0b8f726eb7f389170677f53294b46978db"

S = "${WORKDIR}/git"

inherit cmake_qt5

EXTRA_OECMAKE += " -DBUILD_EXE=1 \
-DBUILD_LIB=1 \ 
-DBUILD_CONF=1 \
-DBUILD_APP=1 \
"

do_install:append() {
    install -d ${D}${sysconfdir}/ssl/certs
    install -m 0755 ${WORKDIR}/youtube.pem ${D}${sysconfdir}/ssl/certs/
}

FILES:${PN} += " \ 
${bindir}/app-hu \
${libdir}/qml/User \
"
