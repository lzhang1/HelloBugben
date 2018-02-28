from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

device = MonkeyRunner.waitForConnection()
dict = device.instrument('com.xuben.hellobugben/android.test.InstrumentationTestRunner')
print dict
