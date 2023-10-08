#!/bin/sh

case "$1" in
    start)
        echo "Loading i2c..."
	modprobe i2c-dev
        modprobe i2c-bcm2708
        ;;
    stop)
        echo "Unloading i2c..."
	modprobe i2c-dev
        modprobe -r i2c-bcm2708
        ;;
    *)
        echo "Usage: /etc/init.d/i2c_auto {start|stop}"
        exit 1
        ;;
esac

exit 0

