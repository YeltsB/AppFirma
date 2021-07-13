package com.aplicacion.appfirma;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.aplicacion.appfirma.transacciones.Transacciones;

import java.util.ArrayList;

public class listaImagenes extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imagenes);

        ListView simpleGridView = (ListView) findViewById(R.id.listView);

        SQLiteConexion help = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        ArrayList<FirmaImagen> listaImagenes = new ArrayList<>();
        Cursor c= help.getAll();
        int i=0;
        if(c.getCount()>0)
        {
            c.moveToFirst();
            while(c.isAfterLast()==false)
            {

                byte[] bytes=c.getBlob(c.getColumnIndex(Transacciones.blobImagen));
                String descripcion=c.getString(c.getColumnIndex(Transacciones.descripcion));

                FirmaImagen fotografia = new FirmaImagen(BitmapFactory.decodeByteArray(bytes, 0, bytes.length), descripcion);
                listaImagenes.add(fotografia);
                c.moveToNext();
                i++;
            }

            Adaptador myAdapter=new Adaptador(this,R.layout.grid_view_items,listaImagenes);
            simpleGridView.setAdapter(myAdapter);
        }
    }
}