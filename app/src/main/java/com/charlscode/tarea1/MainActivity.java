package com.charlscode.tarea1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button mButton;

    EditText etNombre, etNumero, etEmail, etDescripcion;
    TextView TNombre, TNumero, TFechaN, TDescripcion, TEmail;
    Button btFechaNach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //__________________________________________________________________________________________
        //PARA DATE PICKER:
        mDisplayDate = (TextView) findViewById(R.id.btDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int ano = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialogo = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Material_Light_Dialog_MinWidth, mDateSetListener, ano, mes, dia);
              //  dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogo.show();
            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month= month+1;
                Log.d(TAG,"onDateSet: date: "+dayOfMonth+"/"+month+"/"+year);
                String Fecha = month+"/"+dayOfMonth+"/"+year;
                mDisplayDate.setText(Fecha);
            }
        };
        //FIN DATE PICKER
        //__________________________________________________________________________________________

        etNombre=(EditText) findViewById(R.id.eTNombre);
        btFechaNach=(Button)findViewById(R.id.btDate);
        etNumero=(EditText) findViewById(R.id.eTNumero);
        etEmail=(EditText) findViewById(R.id.eTMail);
        etDescripcion=(EditText) findViewById(R.id.eTDescripcion);

        mButton = (Button) findViewById(R.id.btnSiguiente);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Confirmar_Datos.class);
                a.putExtra("aNombre", String.valueOf(etNombre.getText().toString()));
                a.putExtra("aFecha",String.valueOf(btFechaNach.getText().toString()));
                a.putExtra("aEmail",String.valueOf(etEmail.getText().toString()));
                a.putExtra("aNumero",String.valueOf(etNumero.getText().toString()));
                a.putExtra("aDescripcion",String.valueOf(etDescripcion.getText().toString()));
                startActivity(a);
            }
            });
    }
}
