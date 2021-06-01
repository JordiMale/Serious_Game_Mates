package com.example.seriousgamemates;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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

public class Juga3 extends AppCompatActivity {

    Button Corretgir;
    Button Ajuda;


    TextView Numero1Fraccio1;
    TextView Numero2Fraccio1;
    TextView Numero1Fraccio2;
    TextView Numero2Fraccio2;

    TextView Numero1Fraccio3;
    TextView Numero2Fraccio3;
    TextView Numero1Fraccio4;
    TextView Numero2Fraccio4;

    TextView Numero1Fraccio5;
    TextView Numero2Fraccio5;
    TextView Numero1Fraccio6;
    TextView Numero2Fraccio6;

    TextView Numero1Fraccio7;
    TextView Numero2Fraccio7;
    TextView Numero1Fraccio8;
    TextView Numero2Fraccio8;

    TextView RepCorr1;
    TextView RepCorr2;
    TextView RepCorr3;
    TextView RepCorr4;

    TextView RepCorr12;
    TextView RepCorr22;
    TextView RepCorr32;
    TextView RepCorr42;



    EditText Posar1Fraccio1;
    EditText Posar2Fraccio1;

    EditText Posar1Fraccio2;
    EditText Posar2Fraccio2;

    EditText Posar1Fraccio3;
    EditText Posar2Fraccio3;

    EditText Posar1Fraccio4;
    EditText Posar2Fraccio4;

    int Numero1Fraccio1global = 0;
    int Numero2Fraccio1global = 0;
    int Numero1Fraccio2global = 0;
    int Numero2Fraccio2global = 0;

    int Numero1Fraccio3global = 0;
    int Numero2Fraccio3global = 0;
    int Numero1Fraccio4global = 0;
    int Numero2Fraccio4global = 0;

    int Numero1Fraccio5global = 0;
    int Numero2Fraccio5global = 0;
    int Numero1Fraccio6global = 0;
    int Numero2Fraccio6global = 0;

    int Numero1Fraccio7global = 0;
    int Numero2Fraccio7global = 0;
    int Numero1Fraccio8global = 0;
    int Numero2Fraccio8global = 0;
    int Puntuacion = 0;
    int Puntuacion2 = 0;

    int ContadorNivell3 = 0;
    int ConENcert3= 0;

    String Identificador;
    String Numero1;
    String Numero2;
    String Numero3;
    String Numero4;

    String Numero5;
    String Numero6;
    String Numero7;
    String Numero8;

    String Numero9;
    String Numero10;
    String Numero11;
    String Numero12;

    String Numero13;
    String Numero14;
    String Numero15;
    String Numero16;

    LottieAnimationView corretco8;
    LottieAnimationView incorrecto8;
    LottieAnimationView corretco9;
    LottieAnimationView incorrecto9;
    LottieAnimationView corretco10;
    LottieAnimationView incorrecto10;
    LottieAnimationView corretco11;
    LottieAnimationView incorrecto11;

    private FirebaseUser Usu = FirebaseAuth.getInstance().getCurrentUser();
    private String Email = Usu.getEmail();

    FirebaseFirestore Acceso = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juga3);

        MirarPersona3();

        Ajuda = (Button)findViewById(R.id.Ajuda3);
        Corretgir = (Button)findViewById(R.id.Corretgir3);


        //Inicialitzar Numeros fraccions

        RepCorr1 = (TextView)findViewById(R.id.RespostaCorrecteAFra);
        RepCorr2 = (TextView)findViewById(R.id.RespostaCorrecteBFra);
        RepCorr3 = (TextView)findViewById(R.id.RespostaCorrecteCFra);
        RepCorr4 = (TextView)findViewById(R.id.RespostaCorrecteDFra);

        RepCorr12 = (TextView)findViewById(R.id.RespostaCorrecteAFra2);
        RepCorr22 = (TextView)findViewById(R.id.RespostaCorrecteBFra2);
        RepCorr32 = (TextView)findViewById(R.id.RespostaCorrecteCFra2);
        RepCorr42 = (TextView)findViewById(R.id.RespostaCorrecteDFra2);

        //Fraccion 1
        Numero1Fraccio1 = (TextView)findViewById(R.id.Numero1Fraccio1);
        Numero2Fraccio1 = (TextView)findViewById(R.id.Numero2Fraccio1);
        //Fraccion 2
        Numero1Fraccio2 = (TextView)findViewById(R.id.Numero1Fraccio2);
        Numero2Fraccio2 = (TextView)findViewById(R.id.Numero2Fraccio2);
        //Fraccion 3
        Numero1Fraccio3 = (TextView)findViewById(R.id.Numero1Fraccio3);
        Numero2Fraccio3 = (TextView)findViewById(R.id.Numero2Fraccio3);
        //Fraccion 4
        Numero1Fraccio4 = (TextView)findViewById(R.id.Numero1Fraccio4);
        Numero2Fraccio4 = (TextView)findViewById(R.id.Numero2Fraccio4);
        //Fraccion 5
        Numero1Fraccio5 = (TextView)findViewById(R.id.Numero1Fraccio5);
        Numero2Fraccio5 = (TextView)findViewById(R.id.Numero2Fraccio5);
        //Fraccion 6
        Numero1Fraccio6 = (TextView)findViewById(R.id.Numero1Fraccio6);
        Numero2Fraccio6 = (TextView)findViewById(R.id.Numero2Fraccio6);
        //Fraccion 7
        Numero1Fraccio7 = (TextView)findViewById(R.id.Numero1Fraccio7);
        Numero2Fraccio7 = (TextView)findViewById(R.id.Numero2Fraccio7);
        //Fraccion 8
        Numero1Fraccio8 = (TextView)findViewById(R.id.Numero1Fraccio8);
        Numero2Fraccio8 = (TextView)findViewById(R.id.Numero2Fraccio8);
        //Posar Fraccion 1
        Posar1Fraccio1 = (EditText)findViewById(R.id.Numero1Resposta1);
        Posar2Fraccio1 = (EditText)findViewById(R.id.Numero2Resposta1);
        //Posar Fraccion 2
        Posar1Fraccio2 = (EditText)findViewById(R.id.Numero1Resposta2);
        Posar2Fraccio2 = (EditText)findViewById(R.id.Numero2Resposta2);
        //Posar Fraccion 3
        Posar1Fraccio3 = (EditText)findViewById(R.id.Numero1Resposta3);
        Posar2Fraccio3 = (EditText)findViewById(R.id.Numero2Resposta3);
        //Posar Fraccion 4
        Posar1Fraccio4 = (EditText)findViewById(R.id.Numero1Resposta4);
        Posar2Fraccio4 = (EditText)findViewById(R.id.Numero2Resposta4);

        corretco8 = (LottieAnimationView)findViewById(R.id.correcto8);
        incorrecto8 = (LottieAnimationView)findViewById(R.id.incorrecto8);
        corretco9 = (LottieAnimationView)findViewById(R.id.correcto9);
        incorrecto9 = (LottieAnimationView)findViewById(R.id.incorrecto9);
        corretco10 = (LottieAnimationView)findViewById(R.id.correcto10);
        incorrecto10 = (LottieAnimationView)findViewById(R.id.incorrecto10);
        corretco11 = (LottieAnimationView)findViewById(R.id.correcto11);
        incorrecto11 = (LottieAnimationView)findViewById(R.id.incorrecto11);


        corretco8.pauseAnimation();
        incorrecto8.pauseAnimation();
        corretco8.setVisibility(View.GONE);
        incorrecto8.setVisibility(View.GONE);

        corretco9.pauseAnimation();
        incorrecto9.pauseAnimation();
        corretco9.setVisibility(View.GONE);
        incorrecto9.setVisibility(View.GONE);

        corretco10.pauseAnimation();
        incorrecto10.pauseAnimation();
        corretco10.setVisibility(View.GONE);
        incorrecto10.setVisibility(View.GONE);

        corretco11.pauseAnimation();
        incorrecto11.pauseAnimation();
        corretco11.setVisibility(View.GONE);
        incorrecto11.setVisibility(View.GONE);


        Ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Juga3.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Ajuda del LVL 3");
                builder.setMessage("Multiplicació de fraccions" +
                        "\nPer multiplicar fraccions:" +
                        "\n·Es multipliquen els numeradors" +
                        "\n·Es multipliquen els denominadors" +
                        "\nExemple:" +
                        "\na/b * c/d = (a*c)/(c*d)" +
                        "\n\n" +
                        "Divisió de fraccions" +
                        "\nPer dividir fraccions:" +
                        "\n·Es multipliquen el numerador de la primera fracció amb el denominador de la segona fracció i" +
                        "es multipliquen el denominador de la segona fracció amb el numerador de la primera fracció." +
                        "\nExemple:" +
                        "\na/b:c/d = (a*d)/(b*c)");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Desmarcar3();
                GenerarNumerosJuga3();

                Corretgir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Correccions3();
                    }
                });

            }
        },2000);
/*
        LVL4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Juga4.class);
                startActivityForResult(intent, 0);
            }
        });

 */

    }

    private void Desmarcar3() {

        Posar1Fraccio1.getText().clear();
        Posar2Fraccio1.getText().clear();
        Posar1Fraccio2.getText().clear();
        Posar2Fraccio2.getText().clear();
        Posar1Fraccio3.getText().clear();
        Posar2Fraccio3.getText().clear();
        Posar1Fraccio4.getText().clear();
        Posar2Fraccio4.getText().clear();

        corretco8.setVisibility(View.GONE);
        incorrecto8.setVisibility(View.GONE);

        corretco9.setVisibility(View.GONE);
        incorrecto9.setVisibility(View.GONE);

        corretco10.setVisibility(View.GONE);
        incorrecto10.setVisibility(View.GONE);

        corretco11.setVisibility(View.GONE);
        incorrecto11.setVisibility(View.GONE);

        RepCorr1.setText("");
        RepCorr12.setText("");
        RepCorr2.setText("");
        RepCorr22.setText("");
        RepCorr3.setText("");
        RepCorr32.setText("");
        RepCorr4.setText("");
        RepCorr42.setText("");


    }

    private void GenerarNumerosJuga3() {
        //Generar numero 1 de la frccion 1
        Numero1Fraccio1global = (int) (Math.random()*10) + 1;
        Numero1 = String.valueOf(Numero1Fraccio1global);
        Numero1Fraccio1.setText(Numero1);

        //Generar numero 2 de la frccion 1
        Numero2Fraccio1global = (int) (Math.random()*10) + 1;
        Numero2 = String.valueOf(Numero2Fraccio1global);
        Numero2Fraccio1.setText(Numero2);

        //Generar numero 1 de la frccion 2
        Numero1Fraccio2global = (int) (Math.random()*10) + 1;
        Numero3 = String.valueOf(Numero1Fraccio2global);
        Numero1Fraccio2.setText(Numero3);

        //Generar numero 2 de la frccion 2
        Numero2Fraccio2global = (int) (Math.random()*10) + 1;
        Numero4 = String.valueOf(Numero2Fraccio2global);
        Numero2Fraccio2.setText(Numero4);

        //Generar numero 1 de la frccion 3
        Numero1Fraccio3global = (int) (Math.random()*10) + 1;
        Numero5 = String.valueOf(Numero1Fraccio3global);
        Numero1Fraccio3.setText(Numero5);

        //Generar numero 2 de la frccion 3
        Numero2Fraccio3global = (int) (Math.random()*10) + 1;
        Numero6 = String.valueOf(Numero2Fraccio3global);
        Numero2Fraccio3.setText(Numero6);

        //Generar numero 1 de la frccion 4
        Numero1Fraccio4global = (int) (Math.random()*10) + 1;
        Numero7 = String.valueOf(Numero1Fraccio4global);
        Numero1Fraccio4.setText(Numero7);

        //Generar numero 2 de la frccion 4
        Numero2Fraccio4global = (int) (Math.random()*10) + 1;
        Numero8 = String.valueOf(Numero2Fraccio4global);
        Numero2Fraccio4.setText(Numero8);

        //Generar numero 1 de la frccion 5
        Numero1Fraccio5global = (int) (Math.random()*10) + 1;
        Numero9 = String.valueOf(Numero1Fraccio5global);
        Numero1Fraccio5.setText(Numero9);

        //Generar numero 2 de la frccion 5
        Numero2Fraccio5global = (int) (Math.random()*10) + 1;
        Numero10 = String.valueOf(Numero2Fraccio5global);
        Numero2Fraccio5.setText(Numero10);

        //Generar numero 1 de la frccion 6
        Numero1Fraccio6global = (int) (Math.random()*10) + 1;
        Numero11 = String.valueOf(Numero1Fraccio6global);
        Numero1Fraccio6.setText(Numero11);

        //Generar numero 2 de la frccion 6
        Numero2Fraccio6global = (int) (Math.random()*10) + 1;
        Numero12 = String.valueOf(Numero2Fraccio6global);
        Numero2Fraccio6.setText(Numero12);

        //Generar numero 1 de la frccion 7
        Numero1Fraccio7global = (int) (Math.random()*10) + 1;
        Numero13 = String.valueOf(Numero1Fraccio7global);
        Numero1Fraccio7.setText(Numero13);

        //Generar numero 2 de la frccion 7
        Numero2Fraccio7global = (int) (Math.random()*10) + 1;
        Numero14 = String.valueOf(Numero2Fraccio7global);
        Numero2Fraccio7.setText(Numero14);

        //Generar numero 1 de la frccion 8
        Numero1Fraccio8global = (int) (Math.random()*10) + 1;
        Numero15 = String.valueOf(Numero1Fraccio8global);
        Numero1Fraccio8.setText(Numero15);

        //Generar numero 2 de la frccion 8
        Numero2Fraccio8global = (int) (Math.random()*10) + 1;
        Numero16 = String.valueOf(Numero2Fraccio8global);
        Numero2Fraccio8.setText(Numero16);
    }

    private void Correccions3() {



                //Primera Fraccio
                int Numero1Final = Integer.parseInt(Numero1);
                int Numero2Final = Integer.parseInt(Numero2);
                //Segona fraccio
                int Numero3Final = Integer.parseInt(Numero3);
                int Numero4Final = Integer.parseInt(Numero4);
                //Calcul primera i segona fraccio
                int Final1 = Numero1Final * Numero3Final;
                int Final2 = Numero2Final * Numero4Final;
                //Posar-ho en un string el resultat.
                String Final1Final = String.valueOf(Final1);
                String Final2Final = String.valueOf(Final2);

                //Tercera Fraccio
                int Numero5Final = Integer.parseInt(Numero5);
                int Numero6Final = Integer.parseInt(Numero6);
                //Quarta fraccio
                int Numero7Final = Integer.parseInt(Numero7);
                int Numero8Final = Integer.parseInt(Numero8);
                //Calcul Tercera i Quarta fraccio
                int Final3 = Numero5Final * Numero8Final;
                int Final4 = Numero6Final * Numero7Final;
                //Posar-ho en un string el resultat.
                String Final3Final = String.valueOf(Final3);
                String Final4Final = String.valueOf(Final4);

                //Cinquena Fraccio
                int Numero9Final = Integer.parseInt(Numero9);
                int Numero10Final = Integer.parseInt(Numero10);
                //Sisena fraccio
                int Numero11Final = Integer.parseInt(Numero11);
                int Numero12Final = Integer.parseInt(Numero12);
                //Calcul Cinquena i Sisena fraccio
                int Final5 = Numero9Final * Numero11Final;
                int Final6 = Numero10Final * Numero12Final;
                //Posar-ho en un string el resultat.
                String Final5Final = String.valueOf(Final5);
                String Final6Final = String.valueOf(Final6);

                //Septima Fraccio
                int Numero13Final = Integer.parseInt(Numero13);
                int Numero14Final = Integer.parseInt(Numero14);
                //Vuitena fraccio
                int Numero15Final = Integer.parseInt(Numero15);
                int Numero16Final = Integer.parseInt(Numero16);
                //Calcul Septima i Vuitena fraccio
                int Final7 = Numero13Final * Numero16Final;
                int Final8 = Numero14Final * Numero15Final;
                //Posar-ho en un string el resultat.
                String Final7Final = String.valueOf(Final7);
                String Final8Final = String.valueOf(Final8);

                System.out.println(Final5Final);
                System.out.println(Final6Final);
                System.out.println(Final7Final);
                System.out.println(Final8Final);


                if(Final1Final.equals(Posar1Fraccio1.getText().toString()) &&  Final2Final.equals(Posar2Fraccio1.getText().toString())){
                    corretco8.setVisibility(View.VISIBLE);
                    corretco8.playAnimation();
                    Puntuacion = Puntuacion + 10;
                    ConENcert3 = ConENcert3 + 1;
                }else{
                    incorrecto8.setVisibility(View.VISIBLE);
                    incorrecto8.playAnimation();
                    RepCorr1.setText(Final1Final);
                    RepCorr12.setText(Final2Final);
                }

                if(Final3Final.equals(Posar1Fraccio2.getText().toString()) &&  Final4Final.equals(Posar2Fraccio2.getText().toString())){
                    corretco9.setVisibility(View.VISIBLE);
                    corretco9.playAnimation();
                    Puntuacion = Puntuacion + 10;
                    ConENcert3 = ConENcert3 + 1;
                }else{
                    incorrecto9.setVisibility(View.VISIBLE);
                    incorrecto9.playAnimation();
                    RepCorr2.setText(Final3Final);
                    RepCorr22.setText(Final4Final);

                }

                if(Final5Final.equals(Posar1Fraccio3.getText().toString()) &&  Final6Final.equals(Posar2Fraccio3.getText().toString())){
                    corretco10.setVisibility(View.VISIBLE);
                    corretco10.playAnimation();
                    Puntuacion = Puntuacion + 10;
                    ConENcert3 = ConENcert3 + 1;
                }else{
                    incorrecto10.setVisibility(View.VISIBLE);
                    incorrecto10.playAnimation();
                    RepCorr3.setText(Final5Final);
                    RepCorr32.setText(Final6Final);
                }

                if(Final7Final.equals(Posar1Fraccio4.getText().toString()) &&  Final8Final.equals(Posar2Fraccio4.getText().toString())){
                    corretco11.setVisibility(View.VISIBLE);
                    corretco11.playAnimation();
                    Puntuacion = Puntuacion + 10;
                    ConENcert3 = ConENcert3 + 1;
                }else{
                    incorrecto11.setVisibility(View.VISIBLE);
                    incorrecto11.playAnimation();
                    RepCorr4.setText(Final7Final);
                    RepCorr42.setText(Final7Final);
                }

                ContadorNivell3++;
                ActualitzarPuntu3();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Desmarcar3();
                        GenerarNumerosJuga3();
                    }
                },4000);


                if(ContadorNivell3 == 3){

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if(ConENcert3 >= 6){
                                    //DesblocNivle4();
                                    Intent intent = new Intent(Juga3.this, TriarNivell.class);
                                    startActivityForResult(intent, 0);
                                    finish();
                                }else{
                                    if(ConENcert3 < 6){
                                        Intent intent = new Intent(Juga3.this, TriarNivell.class);
                                        startActivityForResult(intent, 0);
                                        finish();
                                    }
                                }
                            }
                        }, 2000);
                }
            }

    private void DesblocNivle4() {
        Acceso.collection("users").document(Identificador).update("Nivell4",1);
    }


    private void MirarPersona3(){
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

    private void ActualitzarPuntu3(){
        int Variable = Puntuacion + Puntuacion2;
        Acceso.collection("users").document(Identificador).update("Puntuación",Variable);
    }

}