package com.aplicacion.appfirma;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<FirmaImagen> {

    ArrayList<FirmaImagen> listaImagenes = new ArrayList<>();

    public Adaptador(Context context, int textViewResourceId, ArrayList<FirmaImagen> objects) {
        super(context, textViewResourceId, objects);
        listaImagenes = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.grid_view_items, null);
        ImageView imageView = (ImageView) v.findViewById(R.id.img);
        imageView.setImageBitmap(listaImagenes.get(position).getImagen());
        TextView textView = (TextView) v.findViewById(R.id.txt);
        textView.setText(listaImagenes.get(position).getDescripcion());
        return v;
    }

}