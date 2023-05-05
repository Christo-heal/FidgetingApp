package com.example.fidgetingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TempatRahasia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempat_rahasia);
        Intent intent = getIntent();
        String password = intent.getStringExtra(MainActivity.EXTRA_PASSWORD);

        TextView textView = findViewById(R.id.text1);
        textView.setText("Hello " + password);

        Button button = findViewById(R.id.buttonHadiah);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TempatRahasia.this, Hadiah.class);
                startActivity(intent);
            }
        });

    }
}