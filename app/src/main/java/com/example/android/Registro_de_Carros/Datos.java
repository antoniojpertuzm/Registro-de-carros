package com.example.android.Registro_de_Carros;

import java.util.ArrayList;

/**
 * Created by android on 21/04/2018.
 */

public class Datos {
    private static ArrayList<Carro> lista = new ArrayList<Carro>();

    public static void guardar(Carro o) {
        lista.add(o);
    }

    public static ArrayList<Carro> getCarros() {
        return lista;
    }



}

