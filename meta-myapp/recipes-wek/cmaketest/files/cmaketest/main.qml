import QtQuick 2.12
import QtQuick.Window 2.12

Window {
    width: 1024
    height: 600
    visible: true
    title: qsTr("Hello World")
    Image {
        id: cat
        source: "/images/b2.png"
        anchors.fill: parent
    }
}
