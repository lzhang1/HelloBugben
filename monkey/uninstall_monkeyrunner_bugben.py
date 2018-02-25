from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice
import sys

package = 'com.xuben.hellobugben'
device = MonkeyRunner.waitForConnection()
device.removePackage(package)
