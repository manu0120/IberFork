package com.arias.iberfork;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptadorFragment extends RecyclerView.Adapter<MiAdaptadorFragment.ViewHolder> {
    private List<String> dataFragTitulos;
    private List<String> dataFragDescripciones;
    private CardView fragCardView;
    private LayoutInflater fragInflador;

    //constructor para cargar el contexto y listas de RestaurantesFragment
    public MiAdaptadorFragment(Context contexto, List<String> dataFragTitulos, List<String> dataFragDescripciones){
        fragInflador=LayoutInflater.from(contexto);
        this.dataFragTitulos=dataFragTitulos;
        this.dataFragDescripciones=dataFragDescripciones;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textTitulo, textDescripcion;
        CardView cardView;
        //vinculamos estas variables con los controles de row.xml
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitulo=itemView.findViewById(R.id.tvTitulo);
            textDescripcion=itemView.findViewById(R.id.tvDetailsSub);
            cardView=itemView.findViewById(R.id.cvRow);
        }
    }

    @NonNull
    @Override
    //crea los nuevos objetos ViewHolder necesarios para los elementos de la colección
    public MiAdaptadorFragment.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = fragInflador.inflate(R.layout.row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptadorFragment.ViewHolder holder, int position) {
        //dependiendo de que podicion se este enfocando rellenara unos datos u oros
        String fragTitutlo=dataFragTitulos.get(position);
        holder.textTitulo.setText(fragTitutlo);

        String fragDescripcion=dataFragDescripciones.get(position);
        holder.textDescripcion.setText(fragDescripcion);
        //capturo los click de boton de las cardView
        holder.cardView.findViewById(R.id.btnDetalles).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (holder.getAdapterPosition()){
                    case 0:
                        Intent intent=new Intent(view.getContext(), GeneralActivity.class);
                        intent.putExtra("position_holder", holder.getAdapterPosition());
                        view.getContext().startActivity(intent);
                        break;
                    case 1:
                        Intent intent2=new Intent(view.getContext(), GeneralActivity.class);
                        intent2.putExtra("position_holder", holder.getAdapterPosition());
                        view.getContext().startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3=new Intent(view.getContext(), GeneralActivity.class);
                        intent3.putExtra("position_holder", holder.getAdapterPosition());
                        view.getContext().startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4=new Intent(view.getContext(), GeneralActivity.class);
                        intent4.putExtra("position_holder", holder.getAdapterPosition());
                        view.getContext().startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5=new Intent(view.getContext(), GeneralActivity.class);
                        intent5.putExtra("position_holder", holder.getAdapterPosition());
                        view.getContext().startActivity(intent5);
                        break;
                    case 5:
                        Intent intent6=new Intent(view.getContext(), GeneralActivity.class);
                        intent6.putExtra("position_holder", holder.getAdapterPosition());
                        view.getContext().startActivity(intent6);
                        break;
                    case 6:
                        Intent intent7=new Intent(view.getContext(), GeneralActivity.class);
                        intent7.putExtra("position_holder", holder.getAdapterPosition());
                        view.getContext().startActivity(intent7);
                        break;
                    case 7:
                        Intent intent8=new Intent(view.getContext(), GeneralActivity.class);
                        intent8.putExtra("position_holder", holder.getAdapterPosition());
                        view.getContext().startActivity(intent8);
                        break;
                    case 8:
                        Intent intent9=new Intent(view.getContext(), GeneralActivity.class);
                        intent9.putExtra("position_holder", holder.getAdapterPosition());
                        view.getContext().startActivity(intent9);
                        break;
                    default:
                        Intent intent10=new Intent(view.getContext(), GeneralActivity.class);
                        intent10.putExtra("position_holder", holder.getAdapterPosition());
                        view.getContext().startActivity(intent10);
                }
            }
        });

    }

    //cuenta el número de registros para que el adaptador sepa cuando hemos llegado al final
    @Override
    public int getItemCount() {
        return dataFragTitulos.size();
    }


}
