from com.android.monkeyrunner import MonkeyRunner as mr

import os
import sys

supported_formats = ['html', 'text', 'sdk-docs']

if len(sys.argv) != 3:
	print 'help.py: format output'
	print sys.argv
	sys.exit(1)

(format, saveto_path) = sys.argv[1:]

if not format.lower() in supported_formats:
	print 'format %s is not a supported format' % format
	sys.exit(2)

output = mr.help(format=format)
if not output:
	print 'Error generating help format'
	sys.exit(3)

dirname = os.path.dirname(saveto_path)
try:
    os.makedirs(dirname)
except:
    print 'oops'
    pass # It already existed

fp = open(saveto_path, 'w')
fp.write(output)
fp.close()

sys.exit(0)
