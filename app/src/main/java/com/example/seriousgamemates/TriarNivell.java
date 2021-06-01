package com.example.seriousgamemates;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Objects;

public class TriarNivell extends AppCompatActivity {

    Button Potencia;
    Button Fraccio;
    Button NombreEnters;
    Button Grafica;
    Button Unitat;


    FirebaseFirestore Acceso = FirebaseFirestore.getInstance();
    private FirebaseUser Usu = FirebaseAuth.getInstance().getCurrentUser();
    private String Email = Usu.getEmail();

    int Nivell2;
    int Nivell3;
    int Nivell4;
    int Nivell5;
    TextView Enrere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triar_nivell);

/*
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                CargarInfo();
            }
        },1500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Bloquear();
            }
        },1500);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Desbloquear();
            }
        },1500);

 */

        Potencia = (Button) findViewById(R.id.Nivell1);
        NombreEnters = (Button) findViewById(R.id.Nivell2);
        Fraccio = (Button) findViewById(R.id.Nivell3);
        Grafica = (Button) findViewById(R.id.Nivell4);
        Unitat = (Button) findViewById(R.id.Nivell5);

        Enrere = (TextView)findViewById(R.id.EnrereSortirXD);

        Enrere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TriarNivell.this, MainJuga.class);
                startActivity(intent);
            }
        });


        Potencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TriarNivell.this, TiempoCarga.class);
                startActivity(intent);
            }
        });

        NombreEnters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TriarNivell.this, TiempoCarga2.class);
                startActivity(intent);
            }
        });
        Fraccio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TriarNivell.this, TiempoCarga3.class);
                startActivity(intent);
            }
        });

        Grafica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TriarNivell.this, TiempoCarga4.class);
                startActivity(intent);
            }
        });

        Unitat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TriarNivell.this, TiempoCarga5.class);
                startActivity(intent);
            }
        });
    }

    private void CargarInfo(){
            Acceso.collection("users").whereEqualTo("Email", Email).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                            Log.d("TAG", document.getId() + " => " + document.getData());
                            Nivell2 = Integer.parseInt(document.getData().get("Nivell2").toString());
                            Nivell3 = Integer.parseInt(document.getData().get("Nivell3").toString());
                            Nivell4 = Integer.parseInt(document.getData().get("Nivell4").toString());
                            Nivell5 = Integer.parseInt(document.getData().get("Nivell5").toString());
                        }
                    } else {
                        Log.d("TAG", "Error getting documents: ", task.getException());
                    }
                }
            });
        }

        private void Desbloquear(){

            if(Nivell2 == 1){
                NombreEnters.setEnabled(true);
                //NombreEnters.setVisibility();
            }else{
                if(Nivell3 == 1){
                    Fraccio.setEnabled(true);
                    //Fraccio.setVisibility();
                }else{
                    if(Nivell4 == 1){
                        Grafica.setEnabled(true);
                        //Grafica.setVisibility();
                    }else{
                        if(Nivell5 == 1){
                            Unitat.setEnabled(true);
                            //Unitat.setVisibility();
                        }
                    }
                }
            }
        }

        private void Bloquear(){

            if(Nivell2 == 0){
                NombreEnters.setEnabled(false);
            }else{
                if(Nivell3 == 0){
                    Fraccio.setEnabled(false);
                }else{
                    if(Nivell4 == 0){
                        Grafica.setEnabled(false);
                    }else{
                        if(Nivell5 == 0){
                            Unitat.setEnabled(false);
                        }
                    }
                }
            }
        }
    }

