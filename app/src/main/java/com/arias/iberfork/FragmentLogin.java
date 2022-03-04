package com.arias.iberfork;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentLogin extends Fragment {
    Button btnLogin;
    EditText etUser, etPass;
    private SQLiteDatabase bd;
    public FragmentLogin() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_login, container, false);

        etPass=v.findViewById(R.id.ted2);
        etUser=v.findViewById(R.id.ted1);

        AdminSQLite adminSQLite = new AdminSQLite(getContext(), "Usuarios", null, 1);
        bd = adminSQLite.getWritableDatabase();
        btnLogin=v.findViewById(R.id.botonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(getContext(), MainActivity.class);
                Intent intent=new Intent(getContext(), NavigActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }

    public void onStop() {
        super.onStop();
        bd.close();
    }

    public void altaSQL() {
        //Si la base de datos se abrió correctamente
        if(bd != null)
        {
            String usuario = etUser.getText().toString();
            String contra = etPass.getText().toString();


            String sql;
            sql = "INSERT INTO usuarios VALUES ('"+ usuario+ "', '" + contra +"')";
            bd.execSQL(sql);
            etPass.setText("");
            etUser.setText("");

            Toast.makeText(getContext(), "Registro correcto", Toast.LENGTH_SHORT).show();
        }
    }
}