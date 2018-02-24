# Copy this file to $SDK/tools
# Usage: monkeyrunner TestMonkeyRunner_Demo.py

import sys
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice, MonkeyImage

txt1_x = 301
txt1_y = 195
txt2_x = 301
txt2_y = 307
bold_x = 317
bold_y = 479
small_x = 489
small_y = 567
submit_x = 542
submit_y = 683

type = 'DOWN_AND_UP'
seconds = 1
txt1_msg = 'bugben'
txt2_msg = 'bugben'

package = 'com.xuben.hellobugben'
activity = '.ChangeActivity'
component = package + '/' + activity

device = MonkeyRunner.waitForConnection()
device.installPackage('/Users/zhanglei/git/HelloBugben/app/build/outputs/apk/debug/app-debug.apk')
print "Installing hellobugben.apk"

device.startActivity(component)
print "Launching bugben"

MonkeyRunner.sleep(seconds)

device.touch(txt1_x, txt1_y, type)
device.type(txt1_msg)
#device.press('KEYCODE_ENTER', 'DOWN_AND_UP')
print "Inputing txt1..."

device.touch(txt2_x, txt2_y, type)
device.type(txt2_msg)
#device.press('KEYCODE_ENTER', 'DOWN_AND_UP')
print "Inputing txt2..."

device.touch(bold_x, bold_y, type)
print "Selecting bold..."

device.touch(small_x, small_y, type)
print "Selecting small..."

MonkeyRunner.sleep(seconds)

device.touch(submit_x, submit_y, type)
print "Submitting..."

MonkeyRunner.sleep(seconds)

picture = device.takeSnapshot()
picture.writeToFile('./bugben_pic.png', 'png')
print "Complete!"

device.press('KEYCODE_HOME','DOWN_AND_UP')
print "Back to HOME"
