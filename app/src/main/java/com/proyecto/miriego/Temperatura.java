package com.proyecto.miriego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Temperatura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
    }

    public void Atras(View hom){
        Intent homev= new Intent(this,Home.class);
        startActivity(homev);
    }
    public void Apagado(View ini){
        Intent inicio= new Intent(this,IniSesion.class);
        startActivity(inicio);
    }
}