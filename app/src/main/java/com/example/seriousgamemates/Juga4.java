package com.example.seriousgamemates;

//import com.airbnb.lottie.LottieAnimationView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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

public class Juga4 extends AppCompatActivity {

    Button Corretgir;
    Button Ajuda;

    TextView Recoa;
    TextView Recoa2;
    TextView Recob;
    TextView Recob2;

    EditText Resposta1PreguntaAFinal;
    EditText Resposta2PreguntaAFinal;
    EditText Resposta1PreguntaBFinal;
    EditText Resposta2PreguntaBFinal;

    String Identificador;
    String Resposta1 = "GENER";
    String Resposta2 = "AGOST";

    int TemMax = 26;
    int TemMin = 10;
    int Puntuacion = 0;
    int Puntuacion2 = 0;
    int ContadorNivell3 = 0;
    int ConENcert4 = 0;



    LottieAnimationView corretco12;
    LottieAnimationView incorrecto12;
    LottieAnimationView corretco13;
    LottieAnimationView incorrecto13;

    private FirebaseUser Usu = FirebaseAuth.getInstance().getCurrentUser();
    private String Email = Usu.getEmail();

    FirebaseFirestore Acceso = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juga4);

        MirarPersona4();


        Ajuda = (Button)findViewById(R.id.Ajuda4);
        Corretgir = (Button)findViewById(R.id.Corretgir4);

         Recoa = (TextView)findViewById(R.id.ReCoA);
         Recoa2 = (TextView)findViewById(R.id.ReCoA2);
         Recob = (TextView)findViewById(R.id.ReCoB);
         Recob2 = (TextView)findViewById(R.id.ReCoB2);


        Resposta1PreguntaAFinal = (EditText)findViewById(R.id.Resposta1PreguntaA);
        Resposta2PreguntaAFinal = (EditText)findViewById(R.id.Resposta2PreguntaA);
        Resposta1PreguntaBFinal = (EditText)findViewById(R.id.Resposta1PreguntaB);
        Resposta2PreguntaBFinal = (EditText)findViewById(R.id.Resposta2PreguntaB);

        corretco12 = (LottieAnimationView)findViewById(R.id.correcto12);
        incorrecto12 = (LottieAnimationView)findViewById(R.id.incorrecto12);
        corretco13 = (LottieAnimationView)findViewById(R.id.correcto13);
        incorrecto13 = (LottieAnimationView)findViewById(R.id.incorrecto13);




        corretco12.pauseAnimation();
        incorrecto12.pauseAnimation();
        corretco12.setVisibility(View.GONE);
        incorrecto12.setVisibility(View.GONE);

        corretco13.pauseAnimation();
        incorrecto13.pauseAnimation();
        corretco13.setVisibility(View.GONE);
        incorrecto13.setVisibility(View.GONE);



        LayoutInflater imagen_alert = LayoutInflater.from(Juga4.this);
        final View vista = imagen_alert.inflate(R.layout.imatge,null);



        Ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Juga4.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Ajuda del LVL 4");
                builder.setMessage("Ajuda amb les temperatures de cada mes:");
                builder.setView(vista);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Corretgir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Correccions4();
                    }
                });

            }
        },2000);
/*
        LVL5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Juga4.class);
                startActivityForResult(intent, 0);
            }
        });

 */
    }

    private void Correccions4() {

                String TemMaxFinal = String.valueOf(TemMax);
                String TemMinFinal = String.valueOf(TemMin);

                if(Resposta1.equalsIgnoreCase(Resposta1PreguntaAFinal.getText().toString()) && Resposta2.equalsIgnoreCase(Resposta2PreguntaAFinal.getText().toString())){
                    corretco12.setVisibility(View.VISIBLE);
                    corretco12.playAnimation();
                    Puntuacion = Puntuacion + 10;
                    ConENcert4 = ConENcert4 + 2;
                }else{
                    if(Resposta1.equalsIgnoreCase(Resposta1PreguntaAFinal.getText().toString()) && !Resposta2.equalsIgnoreCase(Resposta2PreguntaAFinal.getText().toString())){
                        incorrecto12.setVisibility(View.VISIBLE);
                        incorrecto12.playAnimation();
                        Puntuacion = Puntuacion + 5;
                        ConENcert4 = ConENcert4 + 1;
                        Recoa2.setText(Resposta2);

                    }else{
                        if (!Resposta1.equalsIgnoreCase(Resposta1PreguntaAFinal.getText().toString()) && Resposta2.equalsIgnoreCase(Resposta2PreguntaAFinal.getText().toString())){
                            incorrecto12.setVisibility(View.VISIBLE);
                            incorrecto12.playAnimation();
                            Puntuacion = Puntuacion + 5;
                            ConENcert4 = ConENcert4 + 1;
                            Recoa.setText(Resposta1);
                        }else{
                            if(!Resposta1.equalsIgnoreCase(Resposta1PreguntaAFinal.getText().toString()) && !Resposta2.equalsIgnoreCase(Resposta2PreguntaAFinal.getText().toString())){
                                incorrecto12.setVisibility(View.VISIBLE);
                                incorrecto12.playAnimation();
                                Recoa.setText(Resposta1);
                                Recoa2.setText(Resposta2);
                            }
                        }

                    }

                }

                if(TemMaxFinal.equalsIgnoreCase(Resposta1PreguntaBFinal.getText().toString()) && TemMinFinal.equalsIgnoreCase(Resposta2PreguntaBFinal.getText().toString())){
                    corretco13.setVisibility(View.VISIBLE);
                    corretco13.playAnimation();
                    Puntuacion = Puntuacion + 10;
                    ConENcert4 = ConENcert4 + 1;
                }else{
                    if(TemMaxFinal.equalsIgnoreCase(Resposta1PreguntaBFinal.getText().toString()) && !TemMinFinal.equalsIgnoreCase(Resposta2PreguntaBFinal.getText().toString())){
                        incorrecto13.setVisibility(View.VISIBLE);
                        incorrecto13.playAnimation();
                        Puntuacion = Puntuacion + 5;
                        ConENcert4 = ConENcert4 + 1;
                        Recob2.setText(TemMinFinal);

                    }else{
                        if(!TemMaxFinal.equalsIgnoreCase(Resposta1PreguntaBFinal.getText().toString()) && TemMinFinal.equalsIgnoreCase(Resposta2PreguntaBFinal.getText().toString())){
                            incorrecto13.setVisibility(View.VISIBLE);
                            incorrecto13.playAnimation();
                            Puntuacion = Puntuacion + 5;
                            ConENcert4 = ConENcert4 + 1;
                            Recob.setText(TemMaxFinal);
                        }else{
                            if(!TemMaxFinal.equalsIgnoreCase(Resposta1PreguntaBFinal.getText().toString()) && !TemMinFinal.equalsIgnoreCase(Resposta2PreguntaBFinal.getText().toString())){
                                incorrecto13.setVisibility(View.VISIBLE);
                                incorrecto13.playAnimation();
                                Recob.setText(TemMaxFinal);
                                Recob2.setText(TemMinFinal);
                            }
                        }

                    }

                }

                ActualitzarPuntu4();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(ConENcert4 >= 2){
                                //DesblocNivle5();
                                Intent intent = new Intent(Juga4.this, TriarNivell.class);
                                startActivityForResult(intent, 0);
                                finish();
                            }else{
                                if(ConENcert4 < 2){
                                    Intent intent = new Intent(Juga4.this, TriarNivell.class);
                                    startActivityForResult(intent, 0);
                                    finish();
                                }
                            }

                        }
                    }, 2000);

            }

    private void DesblocNivle5() {
        Acceso.collection("users").document(Identificador).update("Nivell5",1);
    }

    private void MirarPersona4(){
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

    private void ActualitzarPuntu4(){
        int Variable = Puntuacion + Puntuacion2;
        Acceso.collection("users").document(Identificador).update("Puntuación",Variable);
    }

}