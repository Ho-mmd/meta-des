#ENABLE I2C
ENABLE_I2C = "1"

do_deploy:append() {
    # CAN
    echo "dtoverlay=seeed-can-fd-hat-v2" >>$CONFIG
    
    # DSI
    echo "dtparam=i2c_arm=on" >>$CONFIG
    echo "dtoverlay=vc4-kms-dsi-waveshare-panel,7_9_inch" >>$CONFIG
}
