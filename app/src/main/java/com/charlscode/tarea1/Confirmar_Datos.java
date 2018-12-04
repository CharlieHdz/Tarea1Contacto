package com.charlscode.tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmar_Datos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvfecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private Button mButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_confirmar_datos);


        Bundle parametros = getIntent().getExtras();
        String nombre1 = parametros.getString("aNombre"); //nombre
        String fecha = parametros.getString("aFecha");
        String Telefono = parametros.getString("aNumero"); //nombre
        String Email = parametros.getString("aEmail"); //nombre
        String Descripcion = parametros.getString("aDescripcion"); //nombre

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvfecha = (TextView) findViewById(R.id.tvfecha);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre1);
        tvfecha.setText(fecha);
        tvTelefono.setText(Telefono);
        tvEmail.setText(Email);
        tvDescripcion.setText(Descripcion);

        mButtonBack = (Button) findViewById(R.id.btnEditar);
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


}
