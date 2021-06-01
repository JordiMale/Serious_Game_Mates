package com.example.seriousgamemates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class ExplicaBoto extends AppCompatActivity {

    Button CorretgirExemple;
    Button EnrereTutorial;

    LottieAnimationView corretco30;
    LottieAnimationView incorrecto30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explica_boto);

        CorretgirExemple = (Button)findViewById(R.id.BotoenCorretgirTuto);
        EnrereTutorial = (Button)findViewById(R.id.EnrereTutorial);
        corretco30 = (LottieAnimationView)findViewById(R.id.correcto30);
        incorrecto30 = (LottieAnimationView)findViewById(R.id.incorrecto30);

        corretco30.pauseAnimation();
        incorrecto30.pauseAnimation();
        corretco30.setVisibility(View.GONE);
        incorrecto30.setVisibility(View.GONE);

        CorretgirExemple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corretco30.setVisibility(View.VISIBLE);
                corretco30.playAnimation();
                incorrecto30.setVisibility(View.VISIBLE);
                incorrecto30.playAnimation();


            }
        });


        EnrereTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ExplicaBoto.this, TutorialApp.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

    }
}