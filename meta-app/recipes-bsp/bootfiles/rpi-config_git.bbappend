#ENABLE I2C
ENABLE_I2C = "1"

do_deploy:append() {
    echo "# CAN" >> $CONFIG
    echo "dtoverlay=seeed-can-fd-hat-v2" >> $CONFIG
    
    echo "# DSI" >> $CONFIG
    echo "dtparam=i2c_arm=on" >> $CONFIG
    echo "dtoverlay=vc4-kms-dsi-waveshare-panel,7_9_inch" >> $CONFIG
    
    echo "# HDMI" >> $CONFIG
    echo "hdmi_force_hotplug=1" >> $CONFIG
    echo "config_hdmi_boost=10" >> $CONFIG
    echo "hdmi_group=2" >> $CONFIG
    echo "hdmi_mode=87" >> $CONFIG 
    echo "hdmi_cvt 1024 1280 60 6 0 0 0" >> $CONFIG
    
    echo "# Audio" >> $CONFIG
    echo "dtparam=audio=on" >> $CONFIG
    echo "dtoverlay=vc4-kms-v3d,noaudio" >> $CONFIG
    
}
