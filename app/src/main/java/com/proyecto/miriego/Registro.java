package com.proyecto.miriego;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText username, correo, numero, passw, confpass;
    Button registrar;
    private String name, email, contraseña, confcont, numersis;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        username = (EditText) findViewById(R.id.ePersonName);
        correo = (EditText) findViewById(R.id.eEmailAddress);
        numero = (EditText) findViewById(R.id.eNumero);
        passw = (EditText) findViewById(R.id.ePassword);
        confpass = (EditText) findViewById(R.id.ePasswordConfirm);
        registrar = (Button) findViewById(R.id.buttonCrear);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = username.getText().toString();
                email = correo.getText().toString();
                numersis = numero.getText().toString();
                contraseña = passw.getText().toString();
                confcont = confpass.getText().toString();
                
                if (!name.isEmpty() && !email.isEmpty() && !numersis.isEmpty() && !contraseña.isEmpty() && !confcont.isEmpty()){
                    if(contraseña.equals(confcont)){
                        if(contraseña.length()>=6){
                            registrarUsuario();
                            //name,email,numersis,contraseña
                        }else{
                            Toast.makeText(Registro.this, "La Contraseña debe ser Mayor a 6 caracteres", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Registro.this, "La Contraseñas deben ser iguales", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Registro.this, "Debe llenar todos los campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void registrarUsuario(){
        mAuth.createUserWithEmailAndPassword(email,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>();
                    map.put("names", name);
                    map.put("emails", email);
                    map.put("numbers", numersis);
                    map.put("passwords", contraseña);
                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                startActivity(new Intent(Registro.this, Home.class));
                                finish();
                            }else{
                                Toast.makeText(Registro.this, "No se crearon los datos correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(Registro.this, "No se logro registrar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}