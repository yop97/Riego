package com.proyecto.miriego;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Dias extends AppCompatActivity implements View.OnClickListener {

    EditText edHora;
    Button bhora, bmodif;
    private int horas,minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dias);

        edHora = (EditText) findViewById(R.id.eHora);
        bhora = (Button) findViewById(R.id.bHora);
        bmodif = (Button) findViewById(R.id.bCambio);
        bhora.setOnClickListener(this);
    }

    public void Atras(View hom){
        Intent homev= new Intent(this,Home.class);
        startActivity(homev);
    }
    public void Apagado(View ini){
        Intent inicio= new Intent(this,IniSesion.class);
        startActivity(inicio);
    }


    @Override
    public void onClick(View v) {
        if(v== bhora){
            final Calendar c= Calendar.getInstance();
            horas=c.get(Calendar.HOUR_OF_DAY);
            minutos= c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    edHora.setText(hourOfDay+":"+minute);
                }
            },horas,minutos,false);
            timePickerDialog.show();
        }
    }
}