package com.arias.iberfork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvRestaurantes;
    MiAdaptador adaptador;

    ArrayList<String> titulos;
    ArrayList<String> descripciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRestaurantes=findViewById(R.id.rvRestaurantes);

        inicializarTitulos();
        inicializarDescripciones();

        /*  Este “gestor del diseño” va a definir la disposición de los elementos. Es
        decir, si van formando una lista vertical u horizontal, si van formando una cuadrícula, u
        otra variante.  */
        LinearLayoutManager managerLayout = new LinearLayoutManager(this);
        rvRestaurantes.setLayoutManager(managerLayout);

        adaptador=new MiAdaptador(this, titulos, descripciones);
        rvRestaurantes.setAdapter(adaptador);


    }

    private void inicializarTitulos() {
        titulos=new ArrayList<>();

        titulos.add("El Barril de las Cortes");
        titulos.add("Ristorante Pizzería Dante");
        titulos.add("Crudo Pokes & Salads");
        titulos.add("Bosforos Turkish Restaurant");
        titulos.add("Healthy Burrito Toledo");
        titulos.add("Miss Sushi Santa Ana");
        titulos.add("Pic&nic");
        titulos.add("Asiático Chun");
        titulos.add("La Leña Asador");
    }
    private void inicializarDescripciones() {
        descripciones=new ArrayList<>();

        descripciones.add("Restaurante español Gourmet");
        descripciones.add("Restaurante italiano de pizzas");
        descripciones.add("Restaurante de comida hawaiana");
        descripciones.add("Restaurante de comida turca");
        descripciones.add("Restaurante Mexicano");
        descripciones.add("Restaurante japonés de sushi");
        descripciones.add("Restaurante americano Gourmet");
        descripciones.add("Restaurante japonés");
        descripciones.add("Restaurante español Gourmet");
    }


}