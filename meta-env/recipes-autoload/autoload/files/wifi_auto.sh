#!/bin/sh

start() {
    wpa_supplicant -Dnl80211 -i wlan0 -c /etc/wpa_supplicant/wpa_supplicant.conf -B
    dhcpcd wlan0
}

stop() {
    killall wpa_supplicant
    killall dhcpcd
}

case "$1" in
  start)
      start
      ;;
  stop)
      stop
      ;;
  *)
      echo "Usage: $0 {start|stop}"
      exit 1
esac

exit 0

