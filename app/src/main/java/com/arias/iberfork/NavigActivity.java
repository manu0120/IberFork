package com.arias.iberfork;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
//import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class NavigActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navig);

        //hacemos referencia a los coontroles del layout
        mDrawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);

        //empieza de incio una fragmento determinado
        getSupportFragmentManager().beginTransaction().add(R.id.flContent, new RestaurantesFragment()).commit();
        setTitle("Restaurantes");
        //setup toolbar
        setSupportActionBar(toolbar);

        //instancio el toggle (hamburger icon
        toggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, R.string.drawer_open, R.string.drawer_close);
        //sirve para que el Navigation Drawer se sincronize con el toggle
        mDrawerLayout.addDrawerListener(toggle);



        //escuchar los clicks de los item del navigationDrawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemNav(item);
                return false;
            }
        });
    }

    //si se cambia la orientacion del dispositivo se mantiene el menu abierto
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private void selectItemNav(MenuItem item) {
        /* clase responsable de realizar acciones en los fragmentos de tu app, como
        agregarlos, quitarlos o reemplazarlos, así como agregarlos a la pila de
        actividades */
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //identifico que item se ha clickado
        switch(item.getItemId()){
            case R.id.nav_profile:
                ft.replace(R.id.flContent, new ProfileFragment()).commit();
                break;
            case R.id.nav_restaurantes:
                ft.replace(R.id.flContent, new RestaurantesFragment()).commit();

                break;
            case R.id.nav_reservas:
                ft.replace(R.id.flContent, new ProfileFragment()).commit();

                break;
            case R.id.nav_preferencias:
                ft.replace(R.id.flContent, new ProfileFragment()).commit();
                break;
        }
        //selecciono el titulo que va a aparecer en el toolbar
        setTitle(item.getTitle());
        //cada vez que demos click fuera delo NavigationDrawer desaparezca de nuesto NavigationDrawer
        mDrawerLayout.closeDrawers();

    }

    //metodo que sirve para controlar el click del toggle (hamburger icon) y que se abra el menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}