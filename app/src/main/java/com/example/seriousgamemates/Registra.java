package com.example.seriousgamemates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Registra extends AppCompatActivity {

    private FirebaseAuth mAuth;

    EditText PonerCorreo;
    EditText PonerPass;
    EditText PonerNombre;
    TextView Jacompte;

    Button Registrar;

    String Email;
    String Password;
    String Nombre;

    FirebaseFirestore db = FirebaseFirestore.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra);
        mAuth = FirebaseAuth.getInstance();

        PonerCorreo = (EditText)findViewById(R.id.PonerCorreo);
        PonerPass = (EditText)findViewById(R.id.PonerPass);
        PonerNombre = (EditText)findViewById(R.id.PonerNombre);
        Registrar = (Button)findViewById(R.id.BotonRegistra);
        Jacompte = (TextView)findViewById(R.id.Jaconta);

        Jacompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registra.this, Login.class);
                startActivity(intent);
            }
        });

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email = PonerCorreo.getText().toString();
                Password = PonerPass.getText().toString();
                Nombre = PonerNombre.getText().toString();

                Metodo_Registrar();
            }
        });




    }

    private void Metodo_Registrar() {
        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Map<String, Object> user1 = new HashMap<>();

                            user1.put("Email", Email);
                            user1.put("Nombre", Nombre);
                            user1.put("Puntuación", 0);



                            db.collection("users")
                                    .add(user1)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                                            Intent intent = new Intent(Registra.this, TutorialApp.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w("TAG", "Error adding document", e);
                                        }
                                    });

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Registra.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }
}