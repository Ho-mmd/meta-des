#ENABLE I2C
ENABLE_I2C = "1"

do_deploy:append() {
    echo "dtoverlay=seeed-can-fd-hat-v2" >>$CONFIG
}
