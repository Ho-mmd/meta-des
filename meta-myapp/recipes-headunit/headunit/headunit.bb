DESCRIPTION = "headunit"
SECTION = "apps"
LICENSE = "CLOSED"

QT_BASE = " \
qtbase \
"

QT_PKGS = " \
qtconnectivity \
qtgraphicaleffects \
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
qtwebengine \
qtnetworkauth \
openssl \
"

SRC_URI = "git://github.com/SEA-ME-Team4/app-hu.git;protocol=https;nobranch=1 \
"
SRCREV = "bfb269cef28bdff5d430e0190c07c241669e28bd"

S = "${WORKDIR}/git"

inherit cmake_qt5

EXTRA_OECMAKE += "-DCommonAPI_DIR=${WORKDIR}/recipe-sysroot/usr/lib/cmake/CommonAPI/ \
"

do_find_lib() {
    find ${D}${bindir}/app-hu -executable -type f -exec chrpath -d {} \;
}

addtask do_find_lib after do_install before do_package

FILES_${PN} += "${bindir}/app-hu"
