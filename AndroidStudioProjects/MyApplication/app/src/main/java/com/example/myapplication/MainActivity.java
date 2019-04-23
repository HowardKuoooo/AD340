package com.example.myapplication;

import android. support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.util.Log;

import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    final private static String TAG = "ARTEMIS SAYA...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TextView label = new TextView( context: this);
        //lablel.s
        Log.i(TAG, msg: "Main activity created");


        //setContentView(R.layout.activity_main);
        //setContentView(label);

    }

    public void onClick(View view){
        EditText testBox = (EditText)findViewById(R.id.textbox);
        String message = testBox.getText().toString();

        TextView label = (TextView)findViewById(R.id.about_me);
        label.setText("Some ppl call me mud");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(TAG, msg:"Main activity ... starting");
    }

    public void onResume(){
        super.onResume();
        Log.i(TAG, msg:"Main activity ... resuminh");
    }

    public void onPause(){
        super.onPause();
    }

    public void onStop(){
        super.onStop();
    }
    public void onDestory(){
        super.onDestroy();

    }
}
