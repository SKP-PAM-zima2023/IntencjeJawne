package com.example.intencje;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.b1);
        button1.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            intent.putExtra("Value 1", 2.4);
            intent.putExtra("Value 2", "jakiś tekst");
            startActivity(intent);
        });

        Button buttonLog = findViewById(R.id.bLog);


        ActivityResultLauncher<Intent> getResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        Intent intent = o.getData();
                        if(intent != null){
                            CharSequence name = intent.getCharSequenceExtra("name");
                            String comm = String.format("Witaj %s !", name);
                            Toast.makeText(MainActivity.this, comm, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        buttonLog.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignIn.class);
            getResult.launch(intent);
        });
    }
}