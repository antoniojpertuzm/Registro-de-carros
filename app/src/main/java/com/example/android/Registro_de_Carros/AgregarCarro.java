package com.example.android.Registro_de_Carros;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgregarCarro extends AppCompatActivity {
    private TextView txtplaca, txtprecio;
    private  Spinner cmbMarca, cmbModelo, cmbColor;
    private ArrayAdapter<String> adapterMarca, adapterModelo, adapterColor;
    private String opc[];
    private ArrayList<Integer> fotos;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carro);
        txtprecio = findViewById(R.id.txtPrecio);
        txtplaca = findViewById(R.id.txtPlaca);
        cmbMarca = findViewById(R.id.cmbMarca);
        cmbModelo = findViewById(R.id.cmbModelo);
        cmbColor = findViewById(R.id.cmbColor);

        opc = this.getResources().getStringArray(R.array.color);
        adapterColor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc);
        cmbColor.setAdapter(adapterColor);

        opc = this.getResources().getStringArray(R.array.marca);
        adapterMarca = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc);
        cmbMarca.setAdapter(adapterMarca);

        opc = this.getResources().getStringArray(R.array.modelo);
        adapterModelo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc);
        cmbModelo.setAdapter(adapterModelo);


        fotos = new ArrayList<Integer>();
        fotos.add(R.drawable.bm);
        fotos.add(R.drawable.toyo);
        fotos.add(R.drawable.vos);

    }


    public void guardar(View v){
        String precio, placa;
        int marca, modelo, color, foto;

       if(validar()) {
            placa = txtplaca.getText().toString();
            marca = cmbMarca.getSelectedItemPosition();
            modelo = cmbModelo.getSelectedItemPosition();
            color = cmbColor.getSelectedItemPosition();
            precio = txtprecio.getText().toString();
            foto = fotoAleatoria(fotos);

            Carro p = new Carro( placa, marca, modelo, color, precio,foto);
            Datos.agregar(p);

            Snackbar.make(v, getResources().getString(R.string.mensaje_guardado), Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
            limpiar();
       }

    }
    public boolean validar(){

        String placa = txtplaca.getText().toString().trim();
        String precio = txtprecio.getText().toString().trim();

            if (placa.isEmpty()){
            txtplaca.setError(getResources().getString(R.string.error));
            txtplaca.requestFocus();
            return false;
        }
        if (precio.isEmpty()){
            txtprecio.setError(getResources().getString(R.string.error));
            txtprecio.requestFocus();
            return false;
        }

        return true;
    }

    public void limpiar(){
        txtplaca.setText("");
        txtprecio.setText("");
        cmbModelo.setSelection(0);
        cmbMarca.setSelection(0);
        cmbColor.setSelection(0);
        txtplaca.requestFocus();

    }

    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public void limpiar(View v){
        limpiar();
    }

    public void onBackPressed(){

        finish();
        Intent i = new Intent(AgregarCarro.this,Principal.class);

        startActivity(i);

    }

}
