package com.arias.iberfork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LoginViewPagerActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tablayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view_pager);

        viewPager2=findViewById(R.id.viewPager);
        tablayout=findViewById(R.id.tabLayout);

        viewPager2.setAdapter(new ViewPager(this));

        new TabLayoutMediator(tablayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Iniciar sesión");
                    break;
                case 1:
                    tab.setText("SignUp");
                    break;
            }
        }).attach();
    }



    /*@NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new FragmentLogin();
            case 1:
                return new FragmentSignUp();
            //Se ejecuta si el resultado de la expresión no coincide con ningún case
            default:
                return new Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }*/
}