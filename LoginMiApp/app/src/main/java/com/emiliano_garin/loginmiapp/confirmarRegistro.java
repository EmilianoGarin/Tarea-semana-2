package com.emiliano_garin.loginmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmarRegistro extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTel;
    private TextView tvEmail;
    private TextView tvDescripcion;

    Button btnEditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_registro);

        //recuperación de los datos de MainActivity.class

        Bundle extras= getIntent().getExtras();
        String nombre       = extras.getString(getResources().getString(R.string.nombre_completo));
        String fecha        = extras.getString(getResources().getString(R.string.elije_fecha));
        String telefono     = extras.getString(getResources().getString(R.string.telefono));
        String email        = extras.getString(getResources().getString(R.string.email));
        String descripcion  = extras.getString(getResources().getString(R.string.descripcion));

        tvNombre     =(TextView) findViewById(R.id.tvNombre);
        tvFecha      =(TextView) findViewById(R.id.tvFecha);
        tvTel        =(TextView) findViewById(R.id.tvTel);
        tvEmail      =(TextView) findViewById(R.id.tvEmail);
        tvDescripcion=(TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTel.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        //enviando los datos a MainActivity.class

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(this, MainActivity.class);
                i.putExtra(getResources().getString(R.string.nombre_completo), (Parcelable) tvNombre);
                i.putExtra(getResources().getString(R.string.elije_fecha), (Parcelable) tvFecha);
                i.putExtra(getResources().getString(R.string.telefono), (Parcelable) tvTel);
                i.putExtra(getResources().getString(R.string.email), (Parcelable) tvEmail);
                i.putExtra(getResources().getString(R.string.descripcion), (Parcelable) tvDescripcion);
                startActivity(i);
            }
        });




    }
}