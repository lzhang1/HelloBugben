from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice
import sys

device = MonkeyRunner.waitForConnection()
package = 'com.android.settings'
activity = '.Settings'
component = package + '/' + activity
device.startActivity(component)
