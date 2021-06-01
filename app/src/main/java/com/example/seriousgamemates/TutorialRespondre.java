package com.example.seriousgamemates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

public class TutorialRespondre extends AppCompatActivity {

    TextView Numero1;
    TextView Numero2;
    EditText PosarNumero;
    Button CorretgirTuto;
    Button EnrereTuto;

    LottieAnimationView corretco31;
    LottieAnimationView incorrecto31;
    
    int NumeroTuto;
    int Numero2Tuto;
    
    String NumeroTutoFinal;
    String Numero2TutoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_respondre);

        Numero1 = (TextView)findViewById(R.id.NumTutor);
        Numero2 = (TextView)findViewById(R.id.NumTutor2);
        PosarNumero = (EditText)findViewById(R.id.PosarNumTuto);
        CorretgirTuto = (Button)findViewById(R.id.ButtonCorretgirTutorial);
        EnrereTuto = (Button)findViewById(R.id.ButtonEnrere2);

        corretco31 = (LottieAnimationView)findViewById(R.id.correcto31);
        incorrecto31 = (LottieAnimationView)findViewById(R.id.incorrecto31);


        corretco31.pauseAnimation();
        incorrecto31.pauseAnimation();
        corretco31.setVisibility(View.GONE);
        incorrecto31.setVisibility(View.GONE);


        EnrereTuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TutorialRespondre.this, TutorialApp.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
        
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                GenerarNumeros();

                CorretgirTuto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Correccions();
                    }
                });

            }
        },2000);
        
        
    }

    private void Correccions() {

        int Numero1Final = Integer.parseInt(NumeroTutoFinal);
        int Numero2Final = Integer.parseInt(Numero2TutoFinal);
        int Suma =  Numero1Final + Numero2Final;
        String Final1Final = String.valueOf(Suma);

        if(Final1Final.equals(PosarNumero.getText().toString())){
            corretco31.setVisibility(View.VISIBLE);
            corretco31.playAnimation();
        }else{
            incorrecto31.setVisibility(View.VISIBLE);
            incorrecto31.playAnimation();

        }


    }

    private void GenerarNumeros() {

        NumeroTuto = (int) (Math.random()*10) + 1;
        NumeroTutoFinal = String.valueOf(NumeroTuto);
        Numero1.setText(NumeroTutoFinal);

        Numero2Tuto = (int) (Math.random()*5) + 1;
        Numero2TutoFinal = String.valueOf(Numero2Tuto);
        Numero2.setText(Numero2TutoFinal);
    }
}