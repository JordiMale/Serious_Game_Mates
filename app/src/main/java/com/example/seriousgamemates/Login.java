package com.example.seriousgamemates;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Objects;

public class Login extends AppCompatActivity {
    
    EditText Email;
    EditText Pass;
    Button Logi;
    
    String EmailS;
    String PassS;

    String Identificador;

    int Puntuacion2 = 0;
    TextView NoCompte;
    FirebaseFirestore Acceso = FirebaseFirestore.getInstance();
    private FirebaseUser Usu = FirebaseAuth.getInstance().getCurrentUser();
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        Email = (EditText)findViewById(R.id.PoEmail);
        Pass = (EditText)findViewById(R.id.PoPass);
        Logi = (Button)findViewById(R.id.LoginRE);
        NoCompte = (TextView)findViewById(R.id.NoCompte);
        String l = String.valueOf(Usu);
        Log.d("Usuario :):",l );

        NoCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registra.class);
                startActivity(intent);
            }
        });

        Logi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MetodoLogin();
            }
        });
        
    }

    private void MetodoLogin() {
        PassS = Pass.getText().toString();
        EmailS = Email.getText().toString();

        if(!PassS.isEmpty() && !EmailS.isEmpty()){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(EmailS, PassS).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        if(user != null){
                            boolean EmailVeri = user.isEmailVerified();

                            String User =  user.getUid();
                        }

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                MirarPersona();

                            }
                        },1000);




                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(Login.this, MainJuga.class);
                                startActivity(intent);
                                finish();
                            }
                        },1000);

                    }else{
                        Toast.makeText(Login.this, "No esta registrat aquest usuari :(", Toast.LENGTH_LONG);
                    }
                }
            });

        }
    }

    private void MirarPersona(){
        Acceso.collection("users").whereEqualTo("Email",EmailS).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        android.util.Log.d("TAG", document.getId() + " => " + document.getData());
                        Identificador = document.getId();
                        Puntuacion2 = Integer.parseInt(document.getData().get("Puntuación").toString());
                        //usuari = document.getData().get("nom").toString();


                    }
                } else {
                    android.util.Log.d("TAG", "Error getting documents: ", task.getException());
                }
            }
        });
    }


}