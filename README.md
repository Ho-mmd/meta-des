# meta-des (headunit) / Yocto Project layer

Layers & Recipes compatible with Yocto Project

This layer Depends on

1. poky (https://github.com/yoctoproject/poky)
   - branch: kirkstone
   - commit: 0e4966eb77928a07230e031d6d9c477c01ec9cce
2. meta-raspberrypi (https://github.com/agherzan/meta-raspberrypi)
   - branch: master
   - commit: 482d864b8f1af84915ed6a9641e80af4e49a1f63
3. meta-qt5 (https://github.com/meta-qt5/meta-qt5)
   - branch: kirkstone
   - commit: 31930afca79b74e0c788452d71356c1f045e7979
4. meta-openembedded/meta-oe (https://github.com/openembedded/meta-openembedded)
   - branch: kirkstone
   - commit: 9c5541f7e18a1fac3b8dea71e1ebb8398d58e6ff
5. meta-python2 (https://github.com/YoeDistro/meta-python2)
   - branch: kirkstone
   - commit: f02882e2aa9279ca7becca8d0cedbffe88b5a253

## Architecture
![Layer conf](https://github.com/SEA-ME-Team4/meta-des/assets/55338823/b12c9d42-251d-4b29-92e0-724dcfeec7fa)

## Features

### meta-app

- Include headunit recipe (qt application)
- Include some recipes about connectivity 
    - vsomeip
    - commonapi-c++
    - commonapi-c++-someip
- Modify other layers recipes to match our application - qtbase, qtwebengine, rpi-config

### meta-piracer 

- Include piracer-py package recipe
- Include some required recipes to use piracer package  
    - adafruit-blinka
    - adafruit-bus-device
    - adafruit-framebuf
    - adafruit-ina219
    - adafruit-pca8685
    - and more......

### meta-env

- Include recipes about environment setting
    - Wifi
    - Kernel version
    - Auto-login
    - Auto-run (App)
    - config.txt, cmdline.txt

## Quick Guide
1. Clone all layers that have dependencies
2. Add layer in bblayers.conf 
3. Run the "conf.sh" (Change local.conf)

## Reference
- [Yocto Project Documentation](https://docs.yoctoproject.org/4.0.12/singleindex.html)
- [piracer_py](https://github.com/twyleg/piracer_py)
