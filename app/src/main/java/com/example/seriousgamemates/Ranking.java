package com.example.seriousgamemates;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Arrays;

public class Ranking extends AppCompatActivity {
    Button Atras;

    TextView Nombre1;
    TextView Nombre2;
    TextView Nombre3;

    TextView Puntuacio1;
    TextView Puntuacio2;
    TextView Puntuacio3;



    int Aux;

    List<String> NombresGuardados;
    List<Integer> NumerosGuardados;

    String [] NombresGuardadoArray;
    int [] NumerosGuardadosArray;

    FirebaseFirestore Acceso = FirebaseFirestore.getInstance();
    private FirebaseUser Usu = FirebaseAuth.getInstance().getCurrentUser();
    private String Email = Usu.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Atras = (Button)findViewById(R.id.Enrere);

        Nombre1 = (TextView)findViewById(R.id.NombreFinal1);
        Nombre2 = (TextView)findViewById(R.id.NombreFinal2);
        Nombre3 = (TextView)findViewById(R.id.NombreFinal3);


        Puntuacio1 = (TextView)findViewById(R.id.PuntuacionFinal1);
        Puntuacio2 = (TextView)findViewById(R.id.PuntuacionFinal2);
        Puntuacio3 = (TextView)findViewById(R.id.PuntuacionFinal3);


        NombresGuardados = new ArrayList<String>();
        NumerosGuardados = new ArrayList<Integer>();



        MirarPersona();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Forkilla();
            }
        },2000);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                OrdenarUsu();

                Arrays.sort(NumerosGuardadosArray);

                Nombre1.setText(NombresGuardadoArray[0]);
                Puntuacio1.setText(String.valueOf(NumerosGuardadosArray[NumerosGuardadosArray.length -1]));

                Nombre2.setText(NombresGuardadoArray[1]);
                Puntuacio2.setText(String.valueOf(NumerosGuardadosArray[NumerosGuardadosArray.length -2]));

                Nombre3.setText(NombresGuardadoArray[2]);
                Puntuacio3.setText(String.valueOf(NumerosGuardadosArray[NumerosGuardadosArray.length -3]));
            }
        },2000);


        Atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainJuga.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    private void MirarPersona() {
        Acceso.collection("users").whereEqualTo("Email", Email).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        Log.d("TAG", document.getId() + " => " + document.getData());
                        NombresGuardados.add(document.getData().get("Nombre").toString());
                        NumerosGuardados.add(Integer.parseInt(document.getData().get("Puntuación").toString()));
                    }
                } else {
                    Log.d("TAG", "Error getting documents: ", task.getException());
                }
            }
        });

        Aux = 1;

        Acceso.collection("users").whereNotEqualTo("Email",Email).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        Log.d("TAG", document.getId() + " => " + document.getData());
                        NombresGuardados.add(document.getData().get("Nombre").toString());
                        NumerosGuardados.add(Integer.parseInt(document.getData().get("Puntuación").toString()));
                        Aux++;
                    }

                } else {
                    Log.d("TAG", "Error getting documents: ", task.getException());
                }
            }
        });
    }

    private void OrdenarUsu(){
        int VariablePuntos = 0;
        String VariableNombre = "";

          for(int i = 0; i < NumerosGuardadosArray.length; i++ ){
                for(int j = 0; j < NumerosGuardadosArray.length; j++ ){
                    if(NumerosGuardadosArray[i] > NumerosGuardadosArray[j]){
                        VariablePuntos =  NumerosGuardadosArray[i];
                        VariableNombre =  NombresGuardadoArray[i];

                        NombresGuardadoArray[i] = NombresGuardadoArray[j] ;
                        NombresGuardadoArray[j] = VariableNombre;

                        NumerosGuardadosArray[i] = NumerosGuardadosArray[j];
                        NumerosGuardadosArray[j] = VariablePuntos;
                    }
                }
            }
    }

    private void Forkilla(){
        NombresGuardadoArray = new  String[Aux];
        for(int i = 0; i < Aux; i++){
            NombresGuardadoArray[i] = NombresGuardados.get(i);
        }

        NumerosGuardadosArray = new int[Aux];
        for(int j = 0; j < Aux; j++){
            NumerosGuardadosArray[j] = NumerosGuardados.get(j);
        }
    }
}