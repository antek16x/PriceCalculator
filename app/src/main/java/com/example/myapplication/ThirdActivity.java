package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    public static final String PIERWSZA = "dane";
    private TextView tv;
    private Button bEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        double d = intent.getDoubleExtra(PIERWSZA, 0);

        tv = (TextView) findViewById(R.id.tv2);
        bEnd = (Button) findViewById(R.id.bEnd2);

        if(d != 0) {
            String wynik = String.format("The sum of all product is equal to %s", d);
            tv.setText(wynik);
        } else {
            tv.setText("No data for calculations!");
        }

        bEnd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                zakoncz();
            }
        } );
    }

    private void zakoncz() {
        super.finish();
    }
}