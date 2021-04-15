package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String PIERWSZA = "po tych stałych identyfikowane są dane";
    public static final String DRUGA = "przekazane w mapie";
    public static final String TRZECIA = "w obiekcie klasy Intent";
    private TextView tv;
    private Button bEnd;
    private double product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String s = intent.getStringExtra(PIERWSZA);
        double d = intent.getDoubleExtra(DRUGA, 0);
        int i = intent.getIntExtra(TRZECIA, 0);
        product = d*i;

        tv = (TextView) findViewById(R.id.tv);
        bEnd = (Button) findViewById(R.id.bEnd);

        if(!(s == null || s.isEmpty() || d == 0 || i == 0)) {
            String wynik = String.format("You have to pay %s for the product %s.", product, s);
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
//
//    private void zakoncz() {
//        super.finish();
//    }

    public void zakoncz() {
        Intent intent = new Intent();
        intent.putExtra(MainActivity.KEY, product);
        setResult(RESULT_OK, intent);
        super.finish();
    }

}