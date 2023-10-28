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

SRC_URI = "git://github.com/SEA-ME-Team4/app-hu.git;protocol=https;nobranch=1 \
file://youtube.pem \
"
SRCREV = "944e7cf10759add4b46be534ea8ab60335e51fdc"

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
