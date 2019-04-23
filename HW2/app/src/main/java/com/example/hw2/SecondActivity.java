package com.example.hw2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.net.Uri;


//As shown in https://www.youtube.com/watch?v=eL69kj-_Wvs
public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "";

    public static final String RESULT = "my.response";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        TextView textView1 = (TextView) findViewById(R.id.textview1);

        textView1.setText(text);

    }

    // As shown in https://github.com/telpirion/AD340/tree/master/Demo_ActivitiesAndIntents
    protected void onClick(View view) {
        EditText textBox = (EditText)findViewById(R.id.response);
        String message = textBox.getText().toString();

        Intent responseIntent = new Intent();
        responseIntent.putExtra(SecondActivity.RESULT, message);

        setResult(Activity.RESULT_OK, responseIntent);
        finish();
    }

}
