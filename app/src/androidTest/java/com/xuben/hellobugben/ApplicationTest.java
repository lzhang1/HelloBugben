package com.xuben.hellobugben;

import android.app.Application;
import android.test.ApplicationTestCase;
import com.xuben.hellobugben.ChangeActivity;
import com.xuben.hellobugben.HelloBugbenActivity;
import com.xuben.hellobugben.R;

import android.app.Instrumentation.ActivityMonitor;
import android.content.Intent;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;
import android.text.TextPaint;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.EditText;

import org.w3c.dom.Text;


public class ApplicationTest extends ActivityInstrumentationTestCase2<ChangeActivity>{
    public ApplicationTest(){
        super(ChangeActivity.class);
    }

    ChangeActivity changeAutoTest;
    HelloBugbenActivity helloBugbenActivity;

    private EditText txt1;
    private EditText txt2;
    private RadioButton bold;
    private RadioButton notbold;
    private RadioButton small;
    private RadioButton big;
    private Button subButton;
    private TextView textview1;
    private TextView textview2;

    String bugben_txt1 = "巴哥奔";
    String bugben_txt2 = "小简介";
    Boolean bugben_bold = true;
    Boolean bugben_notbold = false;
    Float bugben_small_size = (float) 60.0;
    Float bugben_big_size = (float) 180.0;

    @Override
    public void setUp() throws Exception{
        super.setUp();
        Intent intent = new Intent();
        intent.setClassName("com.xuben.hellobugben",ChangeActivity.class.getName());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        changeAutoTest = (ChangeActivity)getInstrumentation().startActivitySync(intent);

        txt1 = (EditText)changeAutoTest.findViewById(R.id.txt1);
        txt2 = (EditText)changeAutoTest.findViewById(R.id.txt2);
        bold = (RadioButton)changeAutoTest.findViewById(R.id.bold);
        notbold = (RadioButton)changeAutoTest.findViewById(R.id.notbold);
        small = (RadioButton)changeAutoTest.findViewById(R.id.small);
        big = (RadioButton)changeAutoTest.findViewById(R.id.big);
        subButton = (Button)changeAutoTest.findViewById(R.id.myButton01);

    }

    @Override
    public void tearDown() throws Exception{
        super.tearDown();
    }

    public void testSubmit() throws Throwable{
        Log.v("testSubmit", "test normal submit.");
        ActivityMonitor bugbenMonitor = getInstrumentation().addMonitor(HelloBugbenActivity.class.getName(),null, false);



        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                txt1.setText(bugben_txt1);
                txt2.setText(bugben_txt2);
                bold.setChecked(false);
                small.setChecked(true);

                SystemClock.sleep(500);
                subButton.performClick();
            }
        });
        helloBugbenActivity = (HelloBugbenActivity)getInstrumentation().waitForMonitor(bugbenMonitor);

        assertTrue(helloBugbenActivity != null);

        textview1 = (TextView)helloBugbenActivity.findViewById(R.id.myTextView01);
        textview2 = (TextView)helloBugbenActivity.findViewById(R.id.myTextView02);

        assertEquals(bugben_txt1, textview1.getText().toString());
        assertEquals(bugben_txt2, textview2.getText().toString());

        TextPaint tp = textview1.getPaint();
        Boolean cmpBold = tp.isFakeBoldText();
        assertFalse(cmpBold);

        Float cmpSize = textview2.getTextSize();
        assertTrue(cmpSize.compareTo(bugben_small_size) == 0);
    }
}