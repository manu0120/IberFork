package com.arias.iberfork;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {

    private LayoutInflater inflador;
    private List<String> dataTitulos;
    private List<String> dataDescripcion;
    private CardView cardview;

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
        String titulo = dataTitulos.get(position);
        holder.textTitulo.setText(titulo);

        String descripcion = dataDescripcion.get(position);
        holder.textDescripcion.setText(descripcion);

        holder.cardView.findViewById(R.id.btnDetalles).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (holder.getAdapterPosition()){
                    case 1:
                        Intent intent=new Intent(view.getContext(), BarrilActivity.class);
                        view.getContext().startActivity(intent);
                        break;
                    default:
                        Intent intent2=new Intent(view.getContext(), BarrilActivity.class);
                        view.getContext().startActivity(intent2);
                        break;
                }
            }
        });
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btnDetalles=view.findViewById(R.id.btnDetalles);


                        switch (holder.getAdapterPosition()){
                            case 1:
                                Intent intent=new Intent(view.getContext(), BarrilActivity.class);
                                view.getContext().startActivity(intent);
                                break;
                            default:
                                Intent intent2=new Intent(view.getContext(), BarrilActivity.class);
                                view.getContext().startActivity(intent2);
                                break;
                        }

                }
            });
        */
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
        CardView cardView;
        ViewHolder (View item){
            super(item);
            textTitulo=item.findViewById(R.id.tvTitulo);
            textDescripcion=item.findViewById(R.id.tvDetailsSub);
            cardView=item.findViewById(R.id.cvRow);
        }
    }
}
