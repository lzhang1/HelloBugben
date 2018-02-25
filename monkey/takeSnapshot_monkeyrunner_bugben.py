from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

device = MonkeyRunner.waitForConnection()
picture = device.takeSnapshot()
picture.writeToFile('./bugben_pic.png', 'png')
