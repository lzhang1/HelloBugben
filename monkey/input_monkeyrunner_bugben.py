from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

bootloader_reboot = 'bootloader'
recovery_reboot = 'recovery'
simple_reboot = 'None'

device = MonkeyRunner.waitForConnection()
device.reboot(recovery_reboot)
