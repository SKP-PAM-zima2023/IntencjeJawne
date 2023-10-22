package com.example.intencje;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            EditText editText = findViewById(R.id.editText);
            CharSequence name = editText.getText();

            Intent intent = new Intent();
            intent.putExtra("name", name);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}