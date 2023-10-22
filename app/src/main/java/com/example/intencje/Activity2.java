package com.example.intencje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            double number = bundle.getDouble("Value 1");
            String text = bundle.getString("Value 2");

            Toast.makeText(this, number+" "+text, Toast.LENGTH_SHORT).show();
        }
    }
}