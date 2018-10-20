package com.example.user.intento_uno;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.intento_uno.Helper.entidad;

import java.util.List;

public class adaptador extends RecyclerView.Adapter<adaptador.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView Nombre,Apellido,Numero;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre =itemView.findViewById(R.id.Nombre);
            Apellido=itemView.findViewById(R.id.Apellido);
            Numero=itemView.findViewById(R.id.Edad);
        }
    }
    private List<entidad>persona;

    public adaptador(List<entidad> persona) {
        this.persona = persona;
    }

    public adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card,viewGroup,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull adaptador.ViewHolder viewHolder, int i) {
        viewHolder.Nombre.setText(persona.get(i).getNombre());
        viewHolder.Apellido.setText(persona.get(i).getApellido());
        viewHolder.Numero.setText(persona.get(i).getEdad());
    }

    @Override
    public int getItemCount() {
        return persona.size();
    }
}
