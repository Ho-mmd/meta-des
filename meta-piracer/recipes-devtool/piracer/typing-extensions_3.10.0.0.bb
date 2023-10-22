SUMMARY = "Backported and Experimental Type Hints for Python 3.8+"
AUTHOR = " <"Guido van Rossum, Jukka Lehtosalo, Łukasz Langa, Michael Lee" <levkivskyi@gmail.com>>"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=64fc2b30b67d0a8423c250e0386ed72f"

SRC_URI = "git://github.com/python/typing_extensions.git;protocol=https;nobranch=1"
SRCREV = "faa7ce22752123e616a08c9e4fe81c3b234c1354"

S = "${WORKDIR}/git"

PN = "typing_extensions"

do_install() {
    install -d ${D}${libdir}/python3.10/site-packages/
    install -m 0755 ${WORKDIR}/git/src_py3/typing_extensions.py ${D}${libdir}/python3.10/site-packages/
}

FILES:${PN} = "${libdir}/python3.10/site-packages/typing_extensions.py"
