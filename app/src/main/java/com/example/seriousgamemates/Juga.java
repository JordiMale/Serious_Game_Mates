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


public class Juga extends AppCompatActivity {

    TextView NumeroPotencia;
    TextView NumeroElevat;
    TextView Numero2Potencia;
    TextView Numero2Elevat;;
    TextView Numero3Elevat;
    TextView Numero4Elevat;
    TextView Numero5Elevat;
    TextView Numero6Elevat;

    TextView NumeroCorrecte;
    TextView NumeroCorrecte2;
    TextView NumeroCorrecte3;
    TextView NumeroCorrecte4;

    EditText PosarPotencia, Posar2Potencia, Posar3potencia, Posar4potencia;
    Button Corretgir;
    Button Ajuda;
    int NumeroPotenciaGlobal = 0;
    int NumeroElevatGlobal = 0;
    int NumeroPotencia2Global = 0;
    int NumeroElevat2Global = 0;
    int NumeroElevat3Global = 0;
    int NumeroElevat4Global = 0;
    int NumeroElevat5Global = 0;
    int NumeroElevat6Global = 0;
    int Puntuacion = 0;
    int Puntuacion2 = 0;
    int ContadorNivell = 0;
    int ContaCorrect = 0;

    String Potencia1;
    String Elevat1;
    String Potencia2;
    String Elevat2;
    String Elevat3;
    String Elevat4;
    String Elevat5;
    String Elevat6;
    String Identificador;

    LottieAnimationView corretco;
    LottieAnimationView incorrecto;
    LottieAnimationView corretco2;
    LottieAnimationView incorrecto2;
    LottieAnimationView corretco3;
    LottieAnimationView incorrecto3;
    LottieAnimationView corretco4;
    LottieAnimationView incorrecto4;

    private FirebaseUser Usu = FirebaseAuth.getInstance().getCurrentUser();
    private String Email = Usu.getEmail();

    FirebaseFirestore Acceso = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juga);
        MirarPersona();


        Ajuda = (Button)findViewById(R.id.Ajuda);
        Corretgir = (Button)findViewById(R.id.Corretgir);
        NumeroPotencia = (TextView)findViewById(R.id.NumeroPotencia);
        NumeroElevat = (TextView)findViewById(R.id.NumeroElevat);
        Numero2Potencia = (TextView)findViewById(R.id.Numero2Potencia);
        Numero2Elevat = (TextView)findViewById(R.id.Numero2Elevat);
        Numero3Elevat = (TextView)findViewById(R.id.Numero3Elevat);
        Numero4Elevat = (TextView)findViewById(R.id.Numero4Elevat);
        Numero5Elevat = (TextView)findViewById(R.id.Numero5Elevat);
        Numero6Elevat = (TextView)findViewById(R.id.Numero6Elevat);

        //Resposta correcte

        NumeroCorrecte = (TextView)findViewById(R.id.RespostaCorrecte1);
        NumeroCorrecte2 = (TextView)findViewById(R.id.RespostaCorrecte2);
        NumeroCorrecte3 = (TextView)findViewById(R.id.RespostaCorrecte3);
        NumeroCorrecte4 = (TextView)findViewById(R.id.RespostaCorrecte4);


        PosarPotencia = (EditText)findViewById(R.id.PosarNumeroPotencia);
        Posar2Potencia = (EditText)findViewById(R.id.PosarNumero2potencia);
        Posar3potencia = (EditText)findViewById(R.id.PosarNumero3Potencia);
        Posar4potencia = (EditText)findViewById(R.id.PosarNumero4Potencia);

        corretco = (LottieAnimationView)findViewById(R.id.correcto);
        incorrecto = (LottieAnimationView)findViewById(R.id.incorrecto);
        corretco2 = (LottieAnimationView)findViewById(R.id.correcto2);
        incorrecto2 = (LottieAnimationView)findViewById(R.id.incorrecto2);
        corretco3 = (LottieAnimationView)findViewById(R.id.correcto3);
        incorrecto3 = (LottieAnimationView)findViewById(R.id.incorrecto3);
        corretco4 = (LottieAnimationView)findViewById(R.id.correcto4);
        incorrecto4 = (LottieAnimationView)findViewById(R.id.incorrecto4);


        corretco.pauseAnimation();
        incorrecto.pauseAnimation();
        corretco.setVisibility(View.GONE);
        incorrecto.setVisibility(View.GONE);

        corretco2.pauseAnimation();
        incorrecto2.pauseAnimation();
        corretco2.setVisibility(View.GONE);
        incorrecto2.setVisibility(View.GONE);

        corretco3.pauseAnimation();
        incorrecto3.pauseAnimation();
        corretco3.setVisibility(View.GONE);
        incorrecto3.setVisibility(View.GONE);

        corretco4.pauseAnimation();
        incorrecto4.pauseAnimation();
        corretco4.setVisibility(View.GONE);
        incorrecto4.setVisibility(View.GONE);



        Ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Juga.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Ajuda del LVL 1");
                builder.setMessage("L'ajuda és:" +
                        "·Concepte de potència\n" +
                        "   \na · a · a · a · a = a^5" +
                        "" +
                        "   \nEs llegeix a elevat a la cinquena potència." +
                        "   \nExemple 2^5 = 32" +
                        "" +
                        "\n\nPropietats de les potències" +
                        "" +
                        "   \nProducte de potències de la mateixa base." +
                        "" +
                        "   \na^n · a^m = a^n+m" +
                        "   \nExemple 2^5 · 2 ^4 = 2 ^9");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
        }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Desmarcar();
                GenerarNumeros();


                Corretgir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Correccions();
                    }
                });

            }
        },2000);

/*
        LVL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Juga2.class);
                startActivityForResult(intent, 0);
            }
        });

 */

    }

    private void GenerarNumeros() {

        NumeroPotenciaGlobal = (int) (Math.random()*10) + 1;
        Potencia1 = String.valueOf(NumeroPotenciaGlobal);
        NumeroPotencia.setText(Potencia1);

        NumeroElevatGlobal = (int) (Math.random()*5) + 1;
        Elevat1 = String.valueOf(NumeroElevatGlobal);
        NumeroElevat.setText(Elevat1);


        NumeroPotencia2Global = (int) (Math.random()*10) + 1;
        Potencia2 = String.valueOf(NumeroPotencia2Global);
        Numero2Potencia.setText(Potencia2);

        NumeroElevat2Global = (int) (Math.random()*5) + 1;
        Elevat2 = String.valueOf(NumeroElevat2Global);
        Numero2Elevat.setText(Elevat2);


        NumeroElevat3Global = (int) (Math.random()*5) + 1;
        Elevat3 = String.valueOf(NumeroElevat3Global);
        Numero3Elevat.setText(Elevat3);

        NumeroElevat4Global = (int) (Math.random()*5) + 1;
        Elevat4 = String.valueOf(NumeroElevat4Global);
        Numero4Elevat.setText(Elevat4);

        NumeroElevat5Global = (int) (Math.random()*5) + 1;
        Elevat5 = String.valueOf(NumeroElevat5Global);
        Numero5Elevat.setText(Elevat5);

        NumeroElevat6Global = (int) (Math.random()*5) + 1;
        Elevat6 = String.valueOf(NumeroElevat6Global);
        Numero6Elevat.setText(Elevat6);
    }

    public void Correccions(){

                //Primer Calcul
                int Numero1 = Integer.parseInt(Potencia1);
                int Numero2 = Integer.parseInt(Elevat1);
                int Elevado1 = (int) Math.pow(Numero1, Numero2);
                String Final1 = String.valueOf(Elevado1);
                System.out.println(Final1);

                //segon Calcul
                int Numero3 = Integer.parseInt(Potencia2);
                int Numero4 = Integer.parseInt(Elevat2);
                int Elevado2 = (int) Math.pow(Numero3, Numero4);
                String Final2 = String.valueOf(Elevado2);
                System.out.println(Final2);


                //Tercer Clacul

                int Numero5 = Integer.parseInt(Elevat3);
                int Numero6 = Integer.parseInt(Elevat4);
                int Suma1 =  Numero5 + Numero6;
                String Final3 = String.valueOf(Suma1);


                //Quart Calcul
                int Numero7 = Integer.parseInt(Elevat5);
                int Numero8 = Integer.parseInt(Elevat6);
                int Suma2 =  Numero7 + Numero8;
                String Final4 = String.valueOf(Suma2);

                if (Final1.equals(PosarPotencia.getText().toString())) {
                    corretco.setVisibility(View.VISIBLE);
                    corretco.playAnimation();
                    ContaCorrect = ContaCorrect + 1;
                    Puntuacion = Puntuacion + 10;
                } else {
                    incorrecto.setVisibility(View.VISIBLE);
                    incorrecto.playAnimation();
                    NumeroCorrecte.setText(Final1);

                }

                if(Final2.equals(Posar2Potencia.getText().toString())){
                    corretco2.setVisibility(View.VISIBLE);
                    corretco2.playAnimation();
                    ContaCorrect = ContaCorrect + 1;
                    Puntuacion = Puntuacion + 10;

                }else{
                    incorrecto2.setVisibility(View.VISIBLE);
                    incorrecto2.playAnimation();
                    NumeroCorrecte2.setText(Final2);
                }

                if(Final3.equals(Posar3potencia.getText().toString())){
                    corretco3.setVisibility(View.VISIBLE);
                    corretco3.playAnimation();
                    ContaCorrect = ContaCorrect + 1;
                    Puntuacion = Puntuacion + 10;
                }else{
                    incorrecto3.setVisibility(View.VISIBLE);
                    incorrecto3.playAnimation();
                    NumeroCorrecte3.setText(Final3);
                }

                if(Final4.equals(Posar4potencia.getText().toString())){
                    corretco4.setVisibility(View.VISIBLE);
                    corretco4.playAnimation();
                    ContaCorrect = ContaCorrect + 1;
                    Puntuacion = Puntuacion + 10;
                }else {
                    incorrecto4.setVisibility(View.VISIBLE);
                    incorrecto4.playAnimation();
                    NumeroCorrecte4.setText(Final4);
                }

                ContadorNivell++;
                ActualitzarPuntu();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Desmarcar();
                        GenerarNumeros();

                    }
                },4000);

                if(ContadorNivell == 3){

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(ContaCorrect >= 6){
                                //DesblocNivle2();
                                Intent intent = new Intent (Juga.this, TriarNivell.class);
                                startActivityForResult(intent, 0);
                                finish();
                            }else{
                                if(ContaCorrect < 6){
                                    Intent intent = new Intent (Juga.this, TriarNivell.class);
                                    startActivityForResult(intent, 0);
                                    finish();
                                }
                            }
                        }
                    },2000);
                }


            }

    private void DesblocNivle2() {
        Acceso.collection("users").document(Identificador).update("Nivell2",1);
    }

    private void MirarPersona(){
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

    private void ActualitzarPuntu(){
        int Variable = Puntuacion + Puntuacion2;
        Acceso.collection("users").document(Identificador).update("Puntuación",Variable);
    }

    private void Desmarcar(){

        PosarPotencia.getText().clear();
        Posar2Potencia.getText().clear();
        Posar3potencia.getText().clear();
        Posar4potencia.getText().clear();

        corretco.setVisibility(View.GONE);
        incorrecto.setVisibility(View.GONE);

        corretco2.setVisibility(View.GONE);
        incorrecto2.setVisibility(View.GONE);

        corretco3.setVisibility(View.GONE);
        incorrecto3.setVisibility(View.GONE);

        corretco4.setVisibility(View.GONE);
        incorrecto4.setVisibility(View.GONE);

         NumeroCorrecte.setText("");
         NumeroCorrecte2.setText("");
         NumeroCorrecte3.setText("");
         NumeroCorrecte4.setText("");

    }

}