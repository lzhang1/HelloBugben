package com.xuben.hellobugben;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.xuben.change.Change;

/**
 * Created by B58862 on 8/30/2016.
 */
public class ChangeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button subButton = (Button)findViewById(R.id.myButton01);
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txt1 = (EditText)findViewById(R.id.txt1);
                EditText txt2 = (EditText)findViewById(R.id.txt2);
                RadioButton bold = (RadioButton) findViewById(R.id.bold);
                RadioButton small = (RadioButton) findViewById(R.id.small);

                String text1 = txt1.getText().toString();
                String text2 = txt2.getText().toString();
                String isBold = bold.isChecked() ? "bold":"notbold";
                String wordSize = small.isChecked() ? "small":"big";

                Change change = new Change(text1,text2,isBold,wordSize);

                Bundle data = new Bundle();
                data.putSerializable("change", change);
                Intent intent = new Intent(ChangeActivity.this, HelloBugbenActivity.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });
    }
}
