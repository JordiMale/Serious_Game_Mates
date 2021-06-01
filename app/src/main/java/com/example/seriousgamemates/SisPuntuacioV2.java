package com.example.seriousgamemates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SisPuntuacioV2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sis_puntuacio_v2);

        Button btenPrincipi = (Button)findViewById(R.id.ButtonPrincipi);

        btenPrincipi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainJuga.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}