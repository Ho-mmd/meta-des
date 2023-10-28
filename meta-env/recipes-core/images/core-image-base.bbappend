TEAM4_LOCAL_GETTY ?= " \
     ${IMAGE_ROOTFS}${systemd_system_unitdir}/serial-getty@.service \
     ${IMAGE_ROOTFS}${systemd_system_unitdir}/getty@.service \
"
# Define a function that modifies the systemd unit config files with the autologin arguments
local_autologin () {
    sed -i -e 's/^\(ExecStart *=.*getty \)/\1--autologin root /' ${TEAM4_LOCAL_GETTY}
}

# Add the function so that it is executed after the rootfs has been generated
ROOTFS_POSTPROCESS_COMMAND += "local_autologin; "
