package com.example.android.Registro_de_Carros;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.Registro_de_Carros.Carro;

import java.util.ArrayList;

/**
 * Created by android on 28/04/2018.
 */

public class AdaptadorCarro extends RecyclerView.Adapter<AdaptadorCarro.CarroViewHolder>{
    private ArrayList<Carro> Carros;

    public AdaptadorCarro(ArrayList<Carro> Carros){
        this.Carros=Carros;
    }

    @Override
    public CarroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_carro,parent,false);
        return new CarroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarroViewHolder holder, int position) {
        Resources res= holder.itemView.getContext().getResources();
        Carro p = Carros.get(position);
        holder.foto.setImageResource(p.getFoto());
        holder.placa.setText(p.getPlaca());
        holder.marca.setText(res.getStringArray(R.array.marca)[p.getMarca()]);
        holder.modelo.setText(res.getStringArray(R.array.modelo)[p.getModelo()]);
        holder.color.setText(res.getStringArray(R.array.color)[p.getColor()]);
        holder.precio.setText(p.getPrecio());
    }

    @Override
    public int getItemCount() {
        return Carros.size();
    }

    public static class CarroViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView placa;
        private TextView marca;
        private TextView modelo;
        private TextView  precio;
        private TextView  color;
        private View v;
        public CarroViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            placa = v.findViewById(R.id.txtplaca);
            marca = v.findViewById(R.id.txtmarca);
            modelo = v.findViewById(R.id.txtmodelo);
            color = v.findViewById(R.id.txtcolor);
            precio = v.findViewById(R.id.txtprecio);
        }
    }

}

