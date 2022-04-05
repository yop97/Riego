package com.proyecto.miriego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PruebaMensajes extends AppCompatActivity {

    EditText etSMS, etCel;
    Button btnenviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_mensajes);
         //definir variables
        etSMS = findViewById(R.id.editTextTextPersonName);
        etCel = findViewById(R.id.editTextTextPersonName2);
        btnenviar = findViewById(R.id.boton);

        //Si la app no tiene permisos esto hara que se lo pida al celular
        if(ActivityCompat.checkSelfPermission(PruebaMensajes.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(PruebaMensajes.this, new String[]{Manifest.permission.SEND_SMS}, 1);
        }

        //Una vez apretado el boton se realizara el envio
        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager= SmsManager.getDefault();
                smsManager.sendTextMessage(etCel.getText().toString(), null, etSMS.getText().toString(),null, null);
                //Una vez enviado el mensaje aparecera este texto "MSJ Enviado"
                Toast.makeText(PruebaMensajes.this, "MSJ Enviado", Toast.LENGTH_LONG).show();
            }
        });

    }
}