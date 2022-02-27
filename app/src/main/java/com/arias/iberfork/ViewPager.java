package com.arias.iberfork;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPager  extends FragmentStateAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragmentsTitle;


    public ViewPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public Fragment getItem(int position) {
        return null;
    }


    public int getCount() {
        return 0;
    }

    @NonNull
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
        return 0;
    }

}
