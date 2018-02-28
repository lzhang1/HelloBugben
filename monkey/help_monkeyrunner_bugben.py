from com.android.monkeyrunner import MonkeyRunner

txt_format = 'text'
html_format = 'html'

monkeyrunner_helptxt = MonkeyRunner.help('text')
monkeyrunner_helptxt = MonkeyRunner.help(txt_format)
monkeyrunner_helphtml = MonkeyRunner.help(html_format)

mrhelp = open('monkeyrunner_help.txt','w');
mrhelp.write(monkeyrunner_helptxt);
mrhelp.close();

mrhelp = open('monkeyrunner_help.html','w');
mrhelp.write(monkeyrunner_helphtml);
mrhelp.close();
