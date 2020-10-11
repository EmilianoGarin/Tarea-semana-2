package com.emiliano_garin.loginmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;


public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnFecha;

    private TextView tilNombre;
    private TextView tilTel;
    private TextView tilEmail;
    private TextView tilDescripcion;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnFecha      = findViewById(R.id.btnFecha);
        btnLogin      = findViewById(R.id.btnLogin);

        tilNombre     = findViewById(R.id.tilNombre);
        tilTel        = findViewById(R.id.tilTel);
        tilEmail      = findViewById(R.id.tilEmail);
        tilDescripcion= findViewById(R.id.tilDescripcion);



        //Material DatePiker
        MaterialDatePicker.Builder builder= MaterialDatePicker.Builder.datePicker();

        builder.setTitleText("Fecha de nacimiento");

        final MaterialDatePicker materialDatePicker=builder.build();

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PIKER");

            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                btnFecha.setText(materialDatePicker.getHeaderText());}//definiendo la fecha en el boton


        });

        //enviando los datos a confirmarRegistro.class

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(this, confirmarRegistro.class);
                i.putExtra(getResources().getString(R.string.nombre_completo), (Parcelable) tilNombre);
                i.putExtra(getResources().getString(R.string.elije_fecha), (Parcelable) materialDatePicker.getHeaderText());
                i.putExtra(getResources().getString(R.string.telefono), (Parcelable) tilTel);
                i.putExtra(getResources().getString(R.string.email), (Parcelable) tilEmail);
                i.putExtra(getResources().getString(R.string.descripcion), (Parcelable) tilDescripcion);
                startActivity(i);
            }
        });

        //recuperacion de los datos de confirmarRegistro.class
        Bundle extras= getIntent().getExtras();
        String nombre       = extras.getString(getResources().getString(R.string.nombre_completo));
        String fecha        = extras.getString(getResources().getString(R.string.elije_fecha));
        String telefono     = extras.getString(getResources().getString(R.string.telefono));
        String email        = extras.getString(getResources().getString(R.string.email));
        String descripcion  = extras.getString(getResources().getString(R.string.descripcion));

        tilNombre.setText(nombre);
        btnFecha.setText(fecha);
        tilTel.setText(telefono);
        tilEmail.setText(email);
        tilDescripcion.setText(descripcion);
    }

}