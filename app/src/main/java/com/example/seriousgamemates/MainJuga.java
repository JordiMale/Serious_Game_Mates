package com.example.seriousgamemates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainJuga extends AppCompatActivity {


    FirebaseFirestore Acceso = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_juga);
        Button btnJuga = (Button) findViewById(R.id.buttonJuga);
        Button btnRanking = (Button) findViewById(R.id.buttonRanking);
        Button btnPuntuacio = (Button) findViewById(R.id.ButtonPuntu);
        Button btneDesconect = (Button) findViewById(R.id.ButtonDeslogearse);



        btnJuga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), TriarNivell.class);
                startActivityForResult(intent, 0);
            }
        });

        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Ranking.class);
                startActivityForResult(intent, 0);
            }
        });


        btnPuntuacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SisPuntuacio.class);
                startActivityForResult(intent, 0);
            }
        });

        btneDesconect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Registra.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
    }
}