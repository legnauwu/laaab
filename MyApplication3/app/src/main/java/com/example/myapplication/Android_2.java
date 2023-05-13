package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Android_2 extends AppCompatActivity {
    private Button agregar_productos_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android2);

        agregar_productos_button = findViewById(R.id.agregar_productos_button);
        agregar_productos_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Android_2.this, Datosqr.class);
                startActivity(intent);
            }
        });

        View textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), Android_3.class);
                startActivity(nextScreen);
            }
        });

        View editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), Android_4.class);
                startActivity(nextScreen);
            }
        });

        View button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(nextScreen);
            }
        });
    }
}