package com.example.seriousgamemates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.api.DistributionOrBuilder;

public class TutorialApp extends AppCompatActivity {

    Button Saltar;
    Button Clica;
    Button Clica2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_app);

        Saltar = (Button)findViewById(R.id.ButtonSaltar);
        Clica = (Button)findViewById(R.id.ButtonClica);
        Clica2 = (Button)findViewById(R.id.ButtonAnarTutorialResondre);

        Saltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TutorialApp.this, MainJuga.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

        Clica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TutorialApp.this, ExplicaBoto.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

        Clica2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TutorialApp.this, TutorialRespondre.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

    }
}