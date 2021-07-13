package com.aplicacion.appfirma;

import android.graphics.Bitmap;

public class FirmaImagen {
    Bitmap imagen;
    String descripcion;

    public FirmaImagen(Bitmap imagen, String descripcion)
    {
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public Bitmap getImagen()
    {
        return imagen;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

}