from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

message = 'Bugben:'
choice = ['bugben','QQ:197162213','http://www.baidu.com']
title = 'Contact Me'

choice = MonkeyRunner.choice(message, choice, title)
