package com.example.android.Registro_de_Carros;

/**
 * Created by android on 21/04/2018.
 */

public class Carro {
    private String placa;
    private int foto;
    private int modelo;
    private int color;
    private int marca;
    private String precio;

    public Carro( String placa, int modelo, int color, int marca, String precio,int foto) {

        this.placa   = placa;
        this.modelo = modelo   ;
        this.color = color;
        this.marca = marca;
        this.precio = precio;
        this.foto = foto;
    }
    public void setFoto(int foto) {      this.foto = foto;    }

    public String getPlaca() {        return placa;    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getModelo() {        return modelo;    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getColor() {        return color;    }

    public void setColor(int color) {        this.color = color;    }

    public int getMarca() {        return marca;    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public String getPrecio() {        return precio;    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public int getFoto() {        return foto;    }

}
