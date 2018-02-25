import android
droid = android.Android()
pkgs = droid.getRunningPackages()
apps = droid.getLaunchableApplications()
print pkgs.result
print apps.result
