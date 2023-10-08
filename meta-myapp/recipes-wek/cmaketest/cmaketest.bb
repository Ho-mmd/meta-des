DESCRIPTION = "cmaketest"
SECTION = "apps"
LICENSE = "CLOSED"

QT_BASE = " \
qtbase \
"

QT_PKGS = " \
qtconnectivity \
qtquickcontrols \
qtquickcontrols2 \
qtdeclarative \
qtgraphicaleffects \
qtmultimedia \
qtwebengine \
"

DEPENDS = "cmake-native \
${QT_BASE} \
${QT_PKGS} \
"

SRC_URI = "file://cmaketest/ \
"

S = "${WORKDIR}/cmaketest"

inherit cmake_qt5

do_configure() {
    export CMAKE_PREFIX_PATH="${WORKDIR}/recipe-sysroot/usr/lib/cmake/Qt5WebEngine:${CMAKE_PREFIX_PATH}"
    
    cmake_do_configure
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/cmaketest ${D}${bindir}
}

FILES_${PN} += "${bindir}/cmaketest"

