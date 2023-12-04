LICENSE = "CLOSED"

SRC_URI = " \
file://DES-PDC-System \
"

inherit cmake_qt5

S = "${WORKDIR}/DES-PDC-System"

QT_BASE = " \
qtbase \
"

QT_PKGS = " \
qtconnectivity \
qtmultimedia \
qtquickcontrols \
qtquickcontrols2 \
qtdeclarative \
"

DEPENDS = "cmake-native \
${QT_BASE} \
${QT_PKGS} \
"

RDEPENDS:${PN} = " \
${QT_PKGS} \
"


