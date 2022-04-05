package com.proyecto.miriego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IniSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Inicio(View ini){
        Intent cambio= new Intent(this,Home.class);
        startActivity(cambio);
    }
    public void Regis(View reg){
        Intent nuevo= new Intent(this, Registro.class);
        startActivity(nuevo);
    }
}