package com.xuben.hellobugben;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.TextView;

import com.xuben.change.Change;

public class HelloBugbenActivity extends Activity {
    private TextView textView1;
    private TextView textView2;

    Boolean bugben_bold = true;
    Boolean bugben_notbold = false;
    Float bugben_small_size = (float) 60.0;
    Float bugben_big_size = (float) 180.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        textView1 = (TextView) findViewById(R.id.myTextView01);
        textView2 = (TextView) findViewById(R.id.myTextView02);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        Change change = (Change) data.getSerializable("change");

        textView1.setText(change.getText1());
        textView2.setText(change.getText2());

        if (change.getBold().equalsIgnoreCase("bold")) {
            TextPaint tp = textView1.getPaint();
            tp.setFakeBoldText(bugben_bold);
        } else if (change.getBold().equalsIgnoreCase("notbold")) {
            TextPaint tp = textView1.getPaint();
            tp.setFakeBoldText(bugben_notbold);
        }

        if (change.getWordSize().equalsIgnoreCase("small")) {
            TextPaint tp = textView2.getPaint();
            tp.setTextSize(bugben_small_size);
        } else if (change.getWordSize().equalsIgnoreCase("big")) {
            TextPaint tp = textView2.getPaint();
            tp.setTextSize(bugben_big_size);
        }
    }
}
