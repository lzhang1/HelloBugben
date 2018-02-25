from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

message = 'Please input bugen QQ:'
initialValue = '1971629467'
title = 'Bugben'
okTitle = 'save'
cancelTitle = 'cancel'

bugbenQQ = MonkeyRunner.input(message, initialValue, title, cancelTitle, okTitle)
MonkeyRunner.alert(bugbenQQ, title, okTitle)
