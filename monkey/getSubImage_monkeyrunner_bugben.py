from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

x = 300
y = 50
w = 200
h = 250

rect = (x,y,w,h)
device = MonkeyRunner.waitForConnection()
picture = device.takeSnapshot()
subpic = picture.getSubImage(rect)
picture.writeToFile('./bugben_pic.png', 'png')
subpic.writeToFile('./bugben_subpic.png', 'png')
