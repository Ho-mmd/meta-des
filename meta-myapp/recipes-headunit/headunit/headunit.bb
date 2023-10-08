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
"

SRC_URI = "file://headunit/ \
"

S = "${WORKDIR}/headunit"

inherit cmake_qt5

do_configure() {   
    export CommonAPI_DIR="${WORKDIR}/recipe-sysroot/usr/lib/cmake/CommonAPI"
    
    cmake_do_configure
}

do_install() {
    install -d ${D}${bindir}
    cp -r ${WORKDIR}/headunit/build/output ${D}${bindir} 
    
    find ${D}${bindir}/output/ -executable -type f -exec chrpath -d {} \;
}

FILES_${PN} += "${bindir}/headunit/output/*"

