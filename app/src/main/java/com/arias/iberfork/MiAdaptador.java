package com.arias.iberfork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {

    private LayoutInflater inflador;
    private List<String> dataTitulos;
    private List<String> dataDescripcion;

    MiAdaptador(Context contexto, List<String> dataTitulos, List<String> dataDescripcion){
        this.inflador=LayoutInflater.from(contexto);
        this.dataTitulos = dataTitulos;
        this.dataDescripcion = dataDescripcion;
    }

    @NonNull
    @Override
    //crea los nuevos objetos ViewHolder necesarios para los elementos de la colección
    public MiAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflador.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    //actualiza los datos de un ViewHolder ya existente
    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.ViewHolder holder, int position) {
        String titulo= dataTitulos.get(position);
        holder.textTitulo.setText(titulo);

        String descripcion= dataDescripcion.get(position);
        holder.textDescripcion.setText(descripcion);
    }

    //cuenta el número de registros para que el adaptador sepa cuando hemos llegado al final
    @Override
    public int getItemCount() {
        return dataTitulos.size();
    }
    /*   Definir la clase interna al adaptador, extendiendo la clase
        RecyclerView.ViewHolder */
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textTitulo, textDescripcion;
        ViewHolder (View item){
            super(item);
            textTitulo=item.findViewById(R.id.tvTitulo);
            textDescripcion=item.findViewById(R.id.tvDetailsSub);

        }
    }
}
