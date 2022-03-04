package com.arias.iberfork;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class ContactoFragment extends Fragment {

    WebView wv1;
    View v;

    public ContactoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_contacto, container, false);
        wv1=v.findViewById(R.id.wb1);
        wv1.loadUrl("https://github.com/manu0120/IberFork");
        return v;
    }
}