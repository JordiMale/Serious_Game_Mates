package com.example.seriousgamemates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SisPuntuacio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sis_puntuacio);

        Button btnSeguent = (Button)findViewById(R.id.ButtonSeguent);

        btnSeguent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SisPuntuacioV2.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}