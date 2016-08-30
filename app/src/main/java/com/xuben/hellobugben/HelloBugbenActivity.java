package com.xuben.hellobugben;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.TextView;

public class HelloBugbenActivity extends Activity {
    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String bugben_txt = "bugben";
        Boolean bugben_bold = true;
        Float bugben_size = (float)20.0;
        textView1 = (TextView)findViewById(R.id.myTextView01);
        textView2 = (TextView)findViewById(R.id.myTextView02);

        setTxt(bugben_txt);
        setTv1Bold(bugben_bold);
        setTv2Size(bugben_size);
    }

    private void setTv2Size(Float size) {
        TextPaint tp = textView2.getPaint();
        tp.setTextSize(size);
    }

    private void setTv1Bold(Boolean bold) {
        TextPaint tp = textView1.getPaint();
        tp.setFakeBoldText(bold);
    }

    private void setTxt(String txt) {
        textView1.setText(txt);
        textView2.setText(txt);
    }


}
