from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

x = 45
y = 185
device = MonkeyRunner.waitForConnection()
picture = device.takeSnapshot()
pixel = picture.getRawPixel(x, y)
pixelint = picture.getRawPixelInt(x, y)
print pixelint
print pixel
