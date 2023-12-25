# Match SSL
OPENSSL_LINKING_MODE = "-linked"

PACKAGECONFIG:append = " openssl gl gles2 eglfs linuxfb fontconfig"
DEPENDS += "userland"
