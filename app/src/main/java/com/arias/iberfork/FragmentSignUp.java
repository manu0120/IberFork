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

public class FragmentSignUp extends Fragment {
    Button btnSignUp;
    EditText etUser1, etPass1;
    private SQLiteDatabase bd;

    public FragmentSignUp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_sign_up, container, false);
        etPass1=v.findViewById(R.id.ted4);
        etUser1=v.findViewById(R.id.ted3);

        btnSignUp=v.findViewById(R.id.botonSignUp);

        AdminSQLite adminSQLite = new AdminSQLite(getContext(), "Usuarios", null, 1);
        bd = adminSQLite.getWritableDatabase();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                altaSQL();
                Intent intent=new Intent(getContext(), NavigActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
    @Override
    public void onStop() {
        super.onStop();
        bd.close();
    }

    public void altaSQL() {
        //Si la base de datos se abrió correctamente
        if(bd != null)
        {
            String usuario = etUser1.getText().toString();
            String contra = etPass1.getText().toString();


            String sql;
            sql = "INSERT INTO usuarios VALUES ('"+ usuario+ "', '" + contra +"')";
            bd.execSQL(sql);
            etPass1.setText("");
            etUser1.setText("");

            Toast.makeText(getContext(), "Registro correcto", Toast.LENGTH_SHORT).show();
        }
    }
}