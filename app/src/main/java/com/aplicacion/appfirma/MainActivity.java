package com.aplicacion.appfirma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnImagenes = (Button) findViewById(R.id.btnVerFirmas);
        Button btnAddFirma = (Button) findViewById(R.id.btnAgregarFirma);
        btnImagenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), listaImagenes.class);
                startActivity(intent);
            }
        });

        btnAddFirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_firma.class);
                startActivity(intent);
            }
        });
    }
}