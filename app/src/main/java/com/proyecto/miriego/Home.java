package com.proyecto.miriego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void Riego(View rie){
        Intent riega= new Intent(this,Dias.class);
        startActivity(riega);
    }
    public void Suelo(View tempe){
        Intent tem= new Intent(this,Temperatura.class);
        startActivity(tem);
    }
    public void Apagado(View ini){
        Intent inicio= new Intent(this,IniSesion.class);
        startActivity(inicio);
    }

}