package com.arias.iberfork;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class RestaurantesFragment extends Fragment {
    RecyclerView rvFragRestaurantes;
    MiAdaptadorFragment adaptador;
    View v;

    ArrayList<String> arTitulos;
    ArrayList<String> arDescripciones;

    public RestaurantesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_restaurantes, container, false);

        rvFragRestaurantes=v.findViewById(R.id.rvFragRestaurantes);
        
        inicTitulos(); 
        inicDescripciones();

        //"Mostrar datos"
        /*  Este “gestor del diseño” va a definir la disposición de los elementos. Es
        decir, si van formando una lista vertical u horizontal, si van formando una cuadrícula, u
        otra variante.  */
        LinearLayoutManager managerLayout = new LinearLayoutManager(getContext());
        rvFragRestaurantes.setLayoutManager(managerLayout);

        //cargamos el adaptador
        adaptador=new MiAdaptadorFragment(getContext(),arTitulos, arDescripciones);
        rvFragRestaurantes.setAdapter(adaptador);
        return v;
    }

    //inicializamos el modelo de datos del RecyclerView
    private void inicDescripciones() {
        arDescripciones=new ArrayList<>();

        arDescripciones.add("Restaurante español Gourmet");
        arDescripciones.add("Restaurante italiano de pizzas");
        arDescripciones.add("Restaurante de comida hawaiana");
        arDescripciones.add("Restaurante de comida turca");
        arDescripciones.add("Restaurante Mexicano");
        arDescripciones.add("Restaurante japonés de sushi");
        arDescripciones.add("Restaurante americano Gourmet");
        arDescripciones.add("Restaurante japonés");
        arDescripciones.add("Restaurante español Gourmet");
    }

    private void inicTitulos() {
        arTitulos=new ArrayList<>();

        arTitulos.add("El Barril de las Cortes");
        arTitulos.add("Ristorante Pizzería Dante");
        arTitulos.add("Crudo Pokes & Salads");
        arTitulos.add("Bosforos Turkish Restaurant");
        arTitulos.add("Healthy Burrito Toledo");
        arTitulos.add("Miss Sushi Santa Ana");
        arTitulos.add("Pic&nic");
        arTitulos.add("Asiático Chun");
        arTitulos.add("La Leña Asador");
    }
}