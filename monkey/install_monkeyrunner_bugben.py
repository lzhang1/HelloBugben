from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice
import sys

device = MonkeyRunner.waitForConnection()
device.installPackage('/Users/zhanglei/git/HelloBugben/app/build/outputs/apk/debug/app-debug.apk')
