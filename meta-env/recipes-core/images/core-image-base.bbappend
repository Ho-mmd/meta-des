# Remove debugging tweaks. These allow the root user to be passwordless.
IMAGE_FEATURES:remove = " \
    debug-tweaks \
"

# Add more users
inherit extrausers

# Set the password for the root user, and create a new user named 'team4`
EXTRA_USERS_PARAMS = " \
    usermod -p root root; \
    useradd -p '' team4 \
"

# Define a variable to hold the list of systemd unit config files to be modified
# Modify the serial console config and the video console config files.
TEAM4_LOCAL_GETTY ?= " \
     ${IMAGE_ROOTFS}${systemd_system_unitdir}/serial-getty@.service \
     ${IMAGE_ROOTFS}${systemd_system_unitdir}/getty@.service \
"
# Define a function that modifies the systemd unit config files with the autologin arguments
local_autologin () {
    sed -i -e 's/^\(ExecStart *=.*getty \)/\1--autologin team4 /' ${TEAM4_LOCAL_GETTY}
}

# Add the function so that it is executed after the rootfs has been generated
ROOTFS_POSTPROCESS_COMMAND += "local_autologin; "
