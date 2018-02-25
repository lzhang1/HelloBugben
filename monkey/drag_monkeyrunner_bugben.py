from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

start = (60, 200)
end = (400, 200)
duration = 1.5
steps = 12

device = MonkeyRunner.waitForConnection()
device.drag(start, end, duration, steps)
