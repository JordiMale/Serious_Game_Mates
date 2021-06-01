package com.example.seriousgamemates;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Objects;

public class Juga2 extends AppCompatActivity {

    Button Corretgir;
    Button Ajuda;

    TextView Numero1Enunciat, Numero2Enunciat;
    TextView RespA;
    TextView RespB;
    TextView RespC;


    EditText RespostaA,  RespostaB,  RespostaC;
    int Puntuacion = 0;
    int Puntuacion2 = 0;
    String Identificador;

    int Numero1EnunciatGlobal = 0;
    String Numero1;

    int Numero2EnunciatGlobal = 0;
    String Numero2;

    int ContadorNivell2 = 0;
    int ContadorEncerts = 0;

    LottieAnimationView corretco5;
    LottieAnimationView incorrecto5;
    LottieAnimationView corretco6;
    LottieAnimationView incorrecto6;
    LottieAnimationView corretco7;
    LottieAnimationView incorrecto7;

    private FirebaseUser Usu = FirebaseAuth.getInstance().getCurrentUser();
    private String Email = Usu.getEmail();

    FirebaseFirestore Acceso = FirebaseFirestore.getInstance();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juga2);
        MirarPersona2();

        Ajuda = (Button)findViewById(R.id.Ajuda2);
        Corretgir = (Button)findViewById(R.id.Corretgir2);

        Numero1Enunciat = (TextView)findViewById(R.id.Numero1Enunciat);
        Numero2Enunciat = (TextView)findViewById(R.id.Numero2Enunciat);

        RespA = (TextView)findViewById(R.id.RespostaCorrecteA);
        RespB = (TextView)findViewById(R.id.RespostaCorrecteB);
        RespC = (TextView)findViewById(R.id.RespostaCorrecteC);

        RespostaA = (EditText)findViewById(R.id.RespostaA);
        RespostaB = (EditText)findViewById(R.id.RespostaB);
        RespostaC = (EditText)findViewById(R.id.RespostaC);

        corretco5 = (LottieAnimationView)findViewById(R.id.correcto5);
        incorrecto5 = (LottieAnimationView)findViewById(R.id.incorrecto5);
        corretco6 = (LottieAnimationView)findViewById(R.id.correcto6);
        incorrecto6 = (LottieAnimationView)findViewById(R.id.incorrecto7);
        corretco7 = (LottieAnimationView)findViewById(R.id.correcto7);
        incorrecto7 = (LottieAnimationView)findViewById(R.id.incorrecto6);



        corretco5.pauseAnimation();
        incorrecto5.pauseAnimation();
        corretco5.setVisibility(View.GONE);
        incorrecto5.setVisibility(View.GONE);

        corretco6.pauseAnimation();
        incorrecto6.pauseAnimation();
        corretco6.setVisibility(View.GONE);
        incorrecto6.setVisibility(View.GONE);

        corretco7.pauseAnimation();
        incorrecto7.pauseAnimation();
        corretco7.setVisibility(View.GONE);
        incorrecto7.setVisibility(View.GONE);


        Ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Juga2.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Ajuda del LVL 2");
                builder.setMessage("\nAjuda pregunta A:" +
                        "\nCada 2 rajoles fan un metre, si l'amplada de la classe són de " + Numero1 + " m" +
                        "\nHauràs de fer 2 per algun número." +
                        "\n" +
                        "\nAjuda pregunta B:" +
                        "\nCada 2 rajoles fan un metre, si l'allargada de la classe són de " + Numero2 + " m" +
                        "\n" +
                        "\nAjuda pregunta C:" +
                        "\nSi tens el nombre de rajoles per l'amplada i el nombre de rajoles per l'allargada.");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Desmarcar2();
                GenerarNumerosJuga2();

                Corretgir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Correccions2();
                    }
                });

            }
        },2000);

        /*
        LVL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Juga3.class);
                startActivityForResult(intent, 0);
            }
        });

         */

    }

    private void Desmarcar2() {

        RespostaA.getText().clear();
        RespostaB.getText().clear();
        RespostaC.getText().clear();

        corretco5.setVisibility(View.GONE);
        incorrecto5.setVisibility(View.GONE);

        corretco6.setVisibility(View.GONE);
        incorrecto6.setVisibility(View.GONE);

        corretco7.setVisibility(View.GONE);
        incorrecto7.setVisibility(View.GONE);

        RespA.setText("");
        RespB.setText("");
        RespC.setText("");


    }

    private void GenerarNumerosJuga2() {
        Numero1EnunciatGlobal = (int) (Math.random()*15) + 1;
        Numero1 = String.valueOf(Numero1EnunciatGlobal);
        Numero1Enunciat.setText(Numero1);

        //Numero 2 enunciat aleatori
        Numero2EnunciatGlobal = (int) (Math.random()*20) + 1;
        Numero2 = String.valueOf(Numero2EnunciatGlobal);
        Numero2Enunciat.setText(Numero2);
    }

    public void Correccions2(){


                //Resposta A
                int Numero1F = Integer.valueOf(Numero1);
                int Numero2F = 2;
                int ResultadoA = Numero1F * Numero2F;
                String FinalA = String.valueOf(ResultadoA);
                //Resposta B
                int Numero3F = Integer.valueOf(Numero2);
                int ResultadoB = Numero3F * Numero2F;
                String FinalB = String.valueOf(ResultadoB);
                //Resposta C
                int Numero4F = ResultadoA;
                int Numero5F = ResultadoB;
                int ResultadoC = Numero4F * Numero5F;
                String ResultadoCFinal = String.valueOf(ResultadoC);

                System.out.println(ResultadoA);
                System.out.println(ResultadoB);
                System.out.println(ResultadoC);


                if(FinalA.equals( RespostaA.getText().toString())){
                    corretco5.setVisibility(View.VISIBLE);
                    corretco5.playAnimation();
                    ContadorEncerts = ContadorEncerts + 1;
                    Puntuacion = Puntuacion + 10;
                }else{
                    incorrecto5.setVisibility(View.VISIBLE);
                    incorrecto5.playAnimation();
                    RespA.setText(FinalA);
                }

                if(FinalB.equals( RespostaB.getText().toString())){
                    corretco6.setVisibility(View.VISIBLE);
                    corretco6.playAnimation();
                    Puntuacion = Puntuacion + 10;
                    ContadorEncerts = ContadorEncerts + 1;
                }else{
                    incorrecto6.setVisibility(View.VISIBLE);
                    incorrecto6.playAnimation();
                    RespB.setText(FinalB);
                }

                if(ResultadoCFinal.equals( RespostaC.getText().toString())){
                    corretco7.setVisibility(View.VISIBLE);
                    corretco7.playAnimation();
                    Puntuacion = Puntuacion + 10;
                    ContadorEncerts = ContadorEncerts + 1;
                }else{
                    incorrecto7.setVisibility(View.VISIBLE);
                    incorrecto7.playAnimation();
                    RespC.setText(ResultadoCFinal);
                }

                ContadorNivell2++;
                ActualitzarPuntu2();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Desmarcar2();
                            GenerarNumerosJuga2();

                        }
                    },4000);


            if(ContadorNivell2 == 3){

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(ContadorEncerts >= 4){
                                //DesblocNivle3();
                                Intent intent = new Intent(Juga2.this, TriarNivell.class);
                                startActivityForResult(intent, 0);
                                finish();
                            }else{
                                if(ContadorEncerts < 4 ){
                                    Intent intent = new Intent(Juga2.this, TriarNivell.class);
                                    startActivityForResult(intent, 0);
                                    finish();
                                }
                            }
                        }
                    }, 2000);
            }
    }

    private void DesblocNivle3() {
        Acceso.collection("users").document(Identificador).update("Nivell3",1);
    }
    private void MirarPersona2(){
        Acceso.collection("users").whereEqualTo("Email",Email).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        Log.d("TAG", document.getId() + " => " + document.getData());
                        Identificador = document.getId();
                        Puntuacion2 = Integer.parseInt(document.getData().get("Puntuación").toString());
                        //usuari = document.getData().get("nom").toString();

                    }
                } else {
                    Log.d("TAG", "Error getting documents: ", task.getException());
                }
            }
        });
    }

    private void ActualitzarPuntu2(){
        int Variable = Puntuacion + Puntuacion2;
        Acceso.collection("users").document(Identificador).update("Puntuación",Variable);
    }

}