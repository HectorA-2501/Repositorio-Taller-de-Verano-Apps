package com.example.veranoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.CharSequenceTransformation;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre, edad;
    Spinner género;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.txt_Nombre);
        edad = findViewById(R.id.txt_Edad);
        género = findViewById(R.id.Spinner_genero);
        agregar = findViewById(R.id.Agregar_txt);
        género = (Spinner) findViewById(R.id.Spinner_genero);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.array_spinner, R.layout.support_simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        género.setAdapter(adapter);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.Agregar_txt:

                        if (nombre.getText().toString().trim().length() == 0)
                            nombre.setError("Nombre Requerido");

                        if (edad.getText().toString().trim().length() == 0)
                            edad.setError("Edad Requerida");

                        Toast.makeText(MainActivity.this, nombre.getText().toString() + "\n" + edad.getText().toString() + "\n" + género.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                        clean ();
                        break;

                }
            }
        });
    }

    private void clean (){
        nombre.setText("");
        edad. setText("");
        género.setSelection(0);
    }

}