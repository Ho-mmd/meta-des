# meta-hu (headunit) / Yocto Project layer

Layers & Recipes compatible with Yocto Project (Released: Kirkstone)

This layer Depends on

1. poky (https://github.com/yoctoproject/poky)
2. meta-raspberrypi (https://github.com/agherzan/meta-raspberrypi)
3. meta-qt5 (https://github.com/meta-qt5/meta-qt5)
4. meta-openembedded/meta-oe (https://github.com/openembedded/meta-openembedded)
5. meta-python2 (https://github.com/YoeDistro/meta-python2)

## Architecture
![Layer conf](https://github.com/SEA-ME-Team4/meta-hu/assets/55338823/dcfb5f03-d4bd-4815-870e-6ea0b17d06fe)

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

- Include recipes about environment setting & init process
    - Wifi
    - booting screen
    - Init script
    - Kernel version
    - Auto-login

## Reference
1. Yocto Project Documentation
https://docs.yoctoproject.org/4.0.12/singleindex.html
