package com.example.android.Registro_de_Carros;

import java.util.ArrayList;

/**
 * Created by android on 21/04/2018.
 */

public class Datos {
    public static ArrayList<Carro> carros = new ArrayList<>();

    public static void agregar(Carro p){
        carros.add(p);
    }

    public static ArrayList<Carro> getCarros(){
        return carros;
    }

}
