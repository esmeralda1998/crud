package com.example.crud;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AcercaDe extends AppCompatActivity {

    TextView tvNombre, tvRedSocial, tvCel, tvDireccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_personales);

        tvNombre = findViewById(R.id.tvnombre);
        tvRedSocial = findViewById(R.id.tvred);
        tvCel = findViewById(R.id.tvcel);
        tvDireccion = findViewById(R.id.tvdireccion);

        informacion();
    }

    public void informacion (){

        tvNombre.setText("Gilma Esmeralda Reyes Cruz");
        tvRedSocial.setText("Facebook: Esmeralda Reyesitha");
        tvCel.setText("7629-5376");
        tvDireccion.setText("Santiago Nonualco,La Paz.");

    }
}