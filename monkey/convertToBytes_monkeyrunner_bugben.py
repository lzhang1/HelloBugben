from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

device = MonkeyRunner.waitForConnection()
picture = device.takeSnapshot()
picstr = picture.convertToBytes('jpg')
print picstr
