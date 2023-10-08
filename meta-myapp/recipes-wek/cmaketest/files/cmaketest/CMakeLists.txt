cmake_minimum_required(VERSION 3.14)

project(cmaketest VERSION 0.1 LANGUAGES CXX)

set(CMAKE_INCLUDE_CURRENT_DIR ON)

set(CMAKE_AUTOUIC ON)
set(CMAKE_AUTOMOC ON)
#set(QT_MOC_EXECUTABLE /usr/bin/moc)
#add_executable(Qt5::moc IMPORTED)
#set_property(TARGET Qt5::moc PROPERTY IMPORTED_LOCATION ${QT_MOC_EXECUTABLE})
set(CMAKE_AUTORCC ON)
#set(QT_RCC_EXECUTABLE /usr/bin/rcc)
#add_executable(Qt5::rcc IMPORTED)
#set_property(TARGET Qt5::rcc PROPERTY IMPORTED_LOCATION ${QT_RCC_EXECUTABLE})

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# QtCreator supports the following variables for Android, which are identical to qmake Android variables.
# Check https://doc.qt.io/qt/deployment-android.html for more information.
# They need to be set before the find_package(...) calls below.

#if(ANDROID)
#    set(ANDROID_PACKAGE_SOURCE_DIR "${CMAKE_CURRENT_SOURCE_DIR}/android")
#    if (ANDROID_ABI STREQUAL "armeabi-v7a")
#        set(ANDROID_EXTRA_LIBS
#            ${CMAKE_CURRENT_SOURCE_DIR}/path/to/libcrypto.so
#            ${CMAKE_CURRENT_SOURCE_DIR}/path/to/libssl.so)
#    endif()
#endif()

set(CMAKE_PREFIX_PATH "/opt/poky/4.0.12/sysroots/x86_64-pokysdk-linux/usr/bin/cmake")

find_package(QT NAMES Qt6 Qt5 COMPONENTS Core Quick REQUIRED)
find_package(Qt5 COMPONENTS Core Quick Gui Network Multimedia WebEngine REQUIRED)

set(PROJECT_SOURCES
        main.cpp
        qml.qrc
)

add_executable(cmaketest
	${PROJECT_SOURCES}
)


target_compile_definitions(cmaketest
  PRIVATE $<$<OR:$<CONFIG:Debug>,$<CONFIG:RelWithDebInfo>>:QT_QML_DEBUG>)
target_link_libraries(cmaketest
  PRIVATE Qt5::Core Qt5::Quick)

set_target_properties(cmaketest PROPERTIES
    MACOSX_BUNDLE_GUI_IDENTIFIER my.example.com
    MACOSX_BUNDLE_BUNDLE_VERSION ${PROJECT_VERSION}
    MACOSX_BUNDLE_SHORT_VERSION_STRING ${PROJECT_VERSION_MAJOR}.${PROJECT_VERSION_MINOR}
)

if(QT_VERSION_MAJOR EQUAL 6)
    qt_import_qml_plugins(cmaketest)
    qt_finalize_executable(cmaketest)
endif()
