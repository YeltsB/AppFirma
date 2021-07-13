package com.aplicacion.appfirma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aplicacion.appfirma.transacciones.Transacciones;

import java.io.ByteArrayOutputStream;

public class activity_firma extends AppCompatActivity {
    public CaptureBitmapView mSig;
    byte[] byteArray;
    ImageView objImagen;
    SQLiteConexion db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firma);

        LinearLayout mContent = (LinearLayout) findViewById(R.id.signLayout);
        mSig = new CaptureBitmapView(this, null);
        mContent.addView(mSig, LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        db = new SQLiteConexion(getApplicationContext(), Transacciones.NameDataBase, null, 1);
        Button btnSalvar = (Button) findViewById(R.id.btn_salvar);
        Button btnClean = (Button) findViewById(R.id.btn_limpiar);
        Button btnLista = (Button) findViewById(R.id.btn_lista);
        EditText descripcion = (EditText) findViewById(R.id.editTextTextPersonName2);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBytes(mSig.getBitmap());
                db.insert(byteArray, descripcion.getText().toString());
                Toast.makeText(getApplicationContext(), "Guardado en la Base de Datos", Toast.LENGTH_LONG).show();
                byteArray = new byte[0];
                descripcion.setText("");
                mSig.ClearCanvas();
            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), listaImagenes.class);
                startActivity(intent);
            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSig.ClearCanvas();
            }
        });
    }

    private void getBytes(Bitmap photo){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byteArray = stream.toByteArray();
    }
}