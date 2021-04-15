package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPrice;
    private EditText etAmount;
    private Button bNext;
    private Button bSum;
    private double sum;
    private final int REQUEST_CODE = 1;
    public static final String KEY = "tutaj stala do intencji";

    private View.OnClickListener action_two = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            intent.putExtra(ThirdActivity.PIERWSZA, sum);
            startActivity(intent);
        }
    };

    private View.OnClickListener action = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            String name = etName.getText().toString();
            double price = Double.parseDouble("0" + etPrice.getText().toString());
            int amount = Integer.parseInt("0" + etAmount.getText().toString());
            intent.putExtra(SecondActivity.PIERWSZA, name);
            intent.putExtra(SecondActivity.DRUGA, price);
            intent.putExtra(SecondActivity.TRZECIA, amount);
            startActivityForResult(intent, REQUEST_CODE);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.name);
        etPrice = (EditText) findViewById(R.id.price);
        etAmount = (EditText) findViewById(R.id.amount);
        bNext = (Button) findViewById(R.id.next);
        bSum = (Button) findViewById(R.id.sum);

        bNext.setOnClickListener(action);
        bSum.setOnClickListener(action_two);
    }

    @Override
    protected void onStart() {
        super.onStart();
        etName.requestFocus();
        etName.setText("");
        etAmount.setText("");
        etPrice.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (intent.hasExtra(KEY)) {
                double part = intent.getDoubleExtra(KEY, 0);
                Toast.makeText(getApplicationContext(), "" + part, Toast.LENGTH_SHORT).show();
                sum += part;
            }
        }
    }

}