package com.example.seriousgamemates;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Final extends AppCompatActivity {

    Button Principi;
    Button Ranking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Principi = (Button)findViewById(R.id.Final);
        Ranking = (Button)findViewById(R.id.RankingFinal);

        Principi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainJuga.class);
                startActivityForResult(intent, 0);
            }
        });

        Ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Ranking.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}