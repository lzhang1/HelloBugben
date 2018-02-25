from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

x = 533
y = 1296
type = 'DOWN_AND_UP'
device = MonkeyRunner.waitForConnection()
device.touch(x, y, type)
