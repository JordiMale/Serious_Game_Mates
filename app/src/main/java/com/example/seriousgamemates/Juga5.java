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
import android.view.LayoutInflater;
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

public class Juga5 extends AppCompatActivity {

    Button Ajuda5;
    Button Corretgir5;

    TextView Numero1;
    TextView Numero2;
    TextView Numero3;
    TextView Numero4;
    TextView Numero5;

    EditText PosarNum1;
    EditText PosarNum2;
    EditText PosarNum3;
    EditText PosarNum4;
    EditText PosarNum5;

    int Puntuacion;
    int Puntuacion2;
    int NumeroUniGlobal = 0;
    int NumeroUniGlobal2 = 0;
    int NumeroUniGlobal3 = 0;
    int NumeroUniGlobal4 = 0;
    int NumeroUniGlobal5 = 0;

    int ContadorNivell5 = 0;
    int Contencerts5 = 0;

    String Uni;
    String Uni2;
    String Uni3;
    String Uni4;
    String Uni5;
    String Identificador;

    LottieAnimationView corretco18;
    LottieAnimationView incorrecto18;
    LottieAnimationView corretco19;
    LottieAnimationView incorrecto19;
    LottieAnimationView corretco20;
    LottieAnimationView incorrecto20;
    LottieAnimationView corretco21;
    LottieAnimationView incorrecto21;
    LottieAnimationView corretco22;
    LottieAnimationView incorrecto22;

    private FirebaseUser Usu = FirebaseAuth.getInstance().getCurrentUser();
    private String Email = Usu.getEmail();

    FirebaseFirestore Acceso = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juga5);
        MirarPersona();

        Ajuda5 = (Button)findViewById(R.id.Ajuda5);
        Corretgir5 = (Button)findViewById(R.id.Corretgir5);

        Numero1 = (TextView)findViewById(R.id.Numero1Uni);
        Numero2 = (TextView)findViewById(R.id.Numero2Uni);
        Numero3 = (TextView)findViewById(R.id.Numero3Uni);
        Numero4 = (TextView)findViewById(R.id.Numero4Uni);
        Numero5 = (TextView)findViewById(R.id.Numero5Uni);

        PosarNum1 = (EditText)findViewById(R.id.PosarNumUni1);
        PosarNum2 = (EditText)findViewById(R.id.PosarNumUni2);
        PosarNum3 = (EditText)findViewById(R.id.PosarNumUni3);
        PosarNum4 = (EditText)findViewById(R.id.PosarNumUni4);
        PosarNum5 = (EditText)findViewById(R.id.PosarNumUni5);

        corretco18 = (LottieAnimationView)findViewById(R.id.correcto18);
        incorrecto18 = (LottieAnimationView)findViewById(R.id.incorrecto18);
        corretco19 = (LottieAnimationView)findViewById(R.id.Correcto19);
        incorrecto19 = (LottieAnimationView)findViewById(R.id.incorrecto19);
        corretco20 = (LottieAnimationView)findViewById(R.id.correcto20);
        incorrecto20 = (LottieAnimationView)findViewById(R.id.incorrecto20);
        corretco21 = (LottieAnimationView)findViewById(R.id.correcto21);
        incorrecto21 = (LottieAnimationView)findViewById(R.id.incorrecto21);
        corretco22 = (LottieAnimationView)findViewById(R.id.correcto22);
        incorrecto22 = (LottieAnimationView)findViewById(R.id.incorrecto22);


        corretco18.pauseAnimation();
        incorrecto18.pauseAnimation();
        corretco18.setVisibility(View.GONE);
        incorrecto18.setVisibility(View.GONE);

        corretco19.pauseAnimation();
        incorrecto19.pauseAnimation();
        corretco19.setVisibility(View.GONE);
        incorrecto19.setVisibility(View.GONE);

        corretco20.pauseAnimation();
        incorrecto20.pauseAnimation();
        corretco20.setVisibility(View.GONE);
        incorrecto20.setVisibility(View.GONE);

        corretco21.pauseAnimation();
        incorrecto21.pauseAnimation();
        corretco21.setVisibility(View.GONE);
        incorrecto21.setVisibility(View.GONE);

        corretco22.pauseAnimation();
        incorrecto22.pauseAnimation();
        corretco22.setVisibility(View.GONE);
        incorrecto22.setVisibility(View.GONE);

        LayoutInflater imagen_alert2 = LayoutInflater.from(Juga5.this);
        final View vista2 = imagen_alert2.inflate(R.layout.imatge2,null);


        Ajuda5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Juga5.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Ajuda del LVL 5");
                builder.setMessage("Canvi d'unitats: "+
                        "Per realitzar canvis d'unitats de longitud hem de " +
                        "multiplicar o dividir per deu tantes" +
                        "vegades com sigui necessari.");
                builder.setView(vista2);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Desmarcar5();
                GenerarNumeros();

                Corretgir5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Correccions();
                    }
                });

            }
        },2000);
    }

    private void Desmarcar5() {

        PosarNum1.getText().clear();
        PosarNum2.getText().clear();
        PosarNum3.getText().clear();
        PosarNum4.getText().clear();
        PosarNum5.getText().clear();

        corretco18.setVisibility(View.GONE);
        incorrecto18.setVisibility(View.GONE);

        corretco19.setVisibility(View.GONE);
        incorrecto19.setVisibility(View.GONE);

        corretco20.setVisibility(View.GONE);
        incorrecto20.setVisibility(View.GONE);

        corretco21.setVisibility(View.GONE);
        incorrecto21.setVisibility(View.GONE);

        corretco22.setVisibility(View.GONE);
        incorrecto22.setVisibility(View.GONE);


    }

    private void Correccions() {

        int Numero1Uni = Integer.parseInt(Uni);
        int Numero1PosarUni = 1000;
        int NumeroUniFinal =  Numero1Uni * Numero1PosarUni;
        String NumeroFinalUni = String.valueOf(NumeroUniFinal);

        int Numero2Uni = Integer.parseInt(Uni2);
        int Numero2PosarUni = 1000;
        int Numero2UniFinal = Numero2Uni * Numero2PosarUni;
        String Numero2FinalUni = String.valueOf(Numero2UniFinal);

        int Numero3Uni = Integer.parseInt(Uni3);
        int Numero3PosarUni = 1000;
        int Numero3UniFinal = Numero3Uni / Numero3PosarUni;
        String Numero3FinalUni = String.valueOf(Numero3UniFinal);

        int Numero4Uni = Integer.parseInt(Uni4);
        int Numero4PosarUni = 100;
        int Numero4UniFinal = Numero4Uni / Numero4PosarUni;
        String Numero4FinalUni = String.valueOf(Numero4UniFinal);

        int Numero5Uni = Integer.parseInt(Uni5);
        int Numero5PosarUni = 100000;
        int Numero5UniFinal = Numero5Uni * Numero5PosarUni;
        String Numero5FinalUni = String.valueOf(Numero5UniFinal);


        if(NumeroFinalUni.equals(PosarNum1.getText().toString())){
            corretco18.setVisibility(View.VISIBLE);
            corretco18.playAnimation();
            Puntuacion = Puntuacion + 10;
            Contencerts5 = Contencerts5 + 1;
        }else{
            incorrecto18.setVisibility(View.VISIBLE);
            incorrecto18.playAnimation();
        }

        if(Numero2FinalUni.equals(PosarNum2.getText().toString())){
            corretco19.setVisibility(View.VISIBLE);
            corretco19.playAnimation();
            Puntuacion = Puntuacion + 10;
            Contencerts5 = Contencerts5 + 1;
        }else{
            incorrecto19.setVisibility(View.VISIBLE);
            incorrecto19.playAnimation();
        }

        if(Numero3FinalUni.equals(PosarNum3.getText().toString())){
            corretco20.setVisibility(View.VISIBLE);
            corretco20.playAnimation();
            Puntuacion = Puntuacion + 10;
            Contencerts5 = Contencerts5 + 1;
        }else{
            incorrecto20.setVisibility(View.VISIBLE);
            incorrecto20.playAnimation();
        }

        if(Numero4FinalUni.equals(PosarNum4.getText().toString())){
            corretco21.setVisibility(View.VISIBLE);
            corretco21.playAnimation();
            Puntuacion = Puntuacion + 10;
            Contencerts5 = Contencerts5 + 1;
        }else{
            incorrecto21.setVisibility(View.VISIBLE);
            incorrecto21.playAnimation();
        }

        if(Numero5FinalUni.equals(PosarNum5.getText().toString())){
            corretco22.setVisibility(View.VISIBLE);
            corretco22.playAnimation();
            Puntuacion = Puntuacion + 10;
            Contencerts5 = Contencerts5 + 1;
        }else{
            incorrecto22.setVisibility(View.VISIBLE);
            incorrecto22.playAnimation();
        }

        ContadorNivell5++;
        ActualitzarPuntu();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Desmarcar5();
                GenerarNumeros();
            }
        },2000);

        if(ContadorNivell5 == 3){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(Contencerts5 >= 7){
                        Intent intent = new Intent (Juga5.this, Final.class);
                        startActivityForResult(intent, 0);
                        finish();
                    }else{
                        if(Contencerts5 < 7){
                            Intent intent = new Intent (Juga5.this, Final.class);
                            startActivityForResult(intent, 0);
                            finish();
                        }
                    }
                }
            },2000);
        }
    }



    private void GenerarNumeros() {

        NumeroUniGlobal = (int) (Math.random()*20) + 1;
        Uni = String.valueOf(NumeroUniGlobal);
        Numero1.setText(Uni);

        NumeroUniGlobal2 = (int) (Math.random()*30) + 1;
        Uni2 = String.valueOf(NumeroUniGlobal2);
        Numero2.setText(Uni2);

        NumeroUniGlobal3 = (int) (Math.random()*40) + 1;
        Uni3 = String.valueOf(NumeroUniGlobal3);
        Numero3.setText(Uni3);

        NumeroUniGlobal4 = (int) (Math.random()*50) + 1;
        Uni4 = String.valueOf(NumeroUniGlobal4);
        Numero4.setText(Uni4);

        NumeroUniGlobal5 = (int) (Math.random()*60) + 1;
        Uni5 = String.valueOf(NumeroUniGlobal5);
        Numero5.setText(Uni);
    }

    private void MirarPersona() {
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
}