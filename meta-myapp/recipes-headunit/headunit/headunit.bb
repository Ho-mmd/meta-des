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
"

DEPENDS = "cmake-native \
${QT_BASE} \
${QT_PKGS} \
vsomeip \
common-api-c++ \ 
common-api-c++-someip \
"

RDEPENDS_${PN} = " \
qtquickcontrols \
qtquickcontrols2 \
qtdeclarative \
bash \
"

SRC_URI = "git://github.com/SEA-ME-Team4/app-hu.git;protocol=https;nobranch=1 \
"
SRCREV = "2d22a82797a40988aded902f99069041bc3ea33d"

S = "${WORKDIR}/git"

inherit cmake_qt5

EXTRA_OECMAKE += "-DCommonAPI_DIR=${WORKDIR}/recipe-sysroot/usr/lib/cmake/CommonAPI/ \
"

do_install:append() {
    install -m 0755 ${S}/shell/starter.sh ${D}${bindir}/app-hu
    install -m 0755 ${S}/shell/killer.sh ${D}${bindir}/app-hu
}

do_find_lib() {
    find ${D}${bindir}/app-hu -executable -type f -exec chrpath -d {} \;
}

addtask do_find_lib after do_install before do_package

FILES_${PN} += "${bindir}/app-hu"
