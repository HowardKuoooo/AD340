package com.example.hw5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import java.lang.Object;

//Reference from https://www.youtube.com/watch?v=ZAVuUAhlRCw

public class MainActivity extends AppCompatActivity {

    EditText temp;
    RadioButton tocelsius;
    RadioButton tofahrenheit;
    Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = (EditText)findViewById(R.id.inputTemp);
        tocelsius = (RadioButton)findViewById(R.id.FtoCRadioButton);
        tofahrenheit = (RadioButton)findViewById(R.id.CtoFRadioButton);
    }


    public void convert(View view) {
        //double inputtemp = new Double(temp.getText().toString());




        /*
        Try to say if inputtemp is null or empty, it will show the toast msg "Enter the valid temperature"
        EditText ed = (EditText) findViewById(R.id.inputTemp);

        String ed_text = ed.getText().toString().trim();

        if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
        {
            Toast.makeText(this, "Please Enter the Valid Temperature  ", Toast.LENGTH_SHORT).show();
            return;
        }

        */
        if (temp.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter the Valid Temperature  ", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            double inputtemp = Double.parseDouble(temp.getText().toString());
            if (tocelsius.isChecked ()) {
                inputtemp = TempConversion.fToc (inputtemp);
            } else if (tofahrenheit.isChecked ()) {
                inputtemp = TempConversion.cTof (inputtemp);
                temp.setText (new Double (inputtemp).toString ());
            }
        }
    }
}
