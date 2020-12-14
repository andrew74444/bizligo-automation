#include <MsgBoxConstants.au3>

Example()

Func Example()
    ;https://www.autoitscript.com/autoit3/docs/functions/FileDirDisk%20Management.htm
ControlFocus("Open","","Edit1")
ControlSetText("Open","","Edit1",@WorkingDir& "\src\test\resources\testImages\Files\ChromePDF3.pdf")
ControlClick("Open","","Button1")

EndFunc   ;==>Example