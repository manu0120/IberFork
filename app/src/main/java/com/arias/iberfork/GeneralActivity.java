package com.arias.iberfork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GeneralActivity extends AppCompatActivity {
    ImageView ivBanner, ivLogo;
    TextView tvTitulo, tvDescripcion, tvDireccion, tvHorarioFecha;
    TextView tvSobreNosotros, tvHorario;
    Button btnLlamar, btnReservar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        ivBanner=findViewById(R.id.ivBanner);
        ivLogo=findViewById(R.id.ivLogo);
        tvTitulo=findViewById(R.id.tvTitulo);
        tvDescripcion=findViewById(R.id.tvDescripcion);
        tvDireccion=findViewById(R.id.tvDireccion);
        tvHorarioFecha=findViewById(R.id.tvHoraioFecha);

        tvSobreNosotros=findViewById(R.id.tvSobreNosotros);
        tvHorario=findViewById(R.id.tvHorario);

        btnLlamar=findViewById(R.id.btnLlamar);
        btnReservar=findViewById(R.id.btnReservar);

        /*  Instancio una variable del objeto Bundle y recibimos la informacion enviada
        (que boton se ha pulsado en el recyclerView) por la actividad anterior. Dependiendo
        de un indice u otro volcaremos una información u otra. Esto lo he hecho para no tener
        que crear muchos activities.   */
        Bundle extras = getIntent().getExtras();
        int indice = extras.getInt("position_holder");

        switch(indice){
            case 0:
                int id=getResources().getIdentifier("com.arias.iberfork:drawable/barril_banner", null, null);
                ivBanner.setImageResource(id);
                ivLogo.setImageResource(R.drawable.barril_logo);
                tvTitulo.setText(R.string.barrilTitulo);
                tvDescripcion.setText(R.string.barrilDescripcion);
                tvDireccion.setText(R.string.barrilDireccion);
                tvHorarioFecha.setText(R.string.barrilHorario);
                break;
            case 1:
                ivBanner.setImageResource(R.drawable.dante_banner);
                ivLogo.setImageResource(R.drawable.dante_logo);
                tvTitulo.setText(R.string.danteTitulo);
                tvDescripcion.setText(R.string.danteDescripcion);
                tvDireccion.setText(R.string.danteDireccion);
                tvHorarioFecha.setText(R.string.danteHorario);
                break;
            case 2:
                ivBanner.setImageResource(R.drawable.crudo_banner);
                ivLogo.setImageResource(R.drawable.crudo_logo);
                tvTitulo.setText(R.string.crudoTitulo);
                tvDescripcion.setText(R.string.crudoDescripcion);
                tvDireccion.setText(R.string.crudoDireccion);
                tvHorarioFecha.setText(R.string.crudoHorario);
                break;
            case 3:
                ivBanner.setImageResource(R.drawable.bosforos_banner);
                ivLogo.setImageResource(R.drawable.bosforos_logo);
                tvTitulo.setText(R.string.bosforosTitulo);
                tvDescripcion.setText(R.string.bosforosDescripcion);
                tvDireccion.setText(R.string.bosforosDireccion);
                tvHorarioFecha.setText(R.string.bosforosHorario);
                break;
            case 4:
                ivBanner.setImageResource(R.drawable.healthy_banner);
                ivLogo.setImageResource(R.drawable.healthy_logo);
                tvTitulo.setText(R.string.healthyTitulo);
                tvDescripcion.setText(R.string.healthyDescripcion);
                tvDireccion.setText(R.string.healthyDireccion);
                tvHorarioFecha.setText(R.string.healthyHorario);
                break;
            case 5:
                ivBanner.setImageResource(R.drawable.misssushi_banner);
                ivLogo.setImageResource(R.drawable.miss_logo);
                tvTitulo.setText(R.string.missTitulo);
                tvDescripcion.setText(R.string.missDescripcion);
                tvDireccion.setText(R.string.missDireccion);
                tvHorarioFecha.setText(R.string.missHorario);
                break;
            case 6:
                ivBanner.setImageResource(R.drawable.picnic_banner);
                ivLogo.setImageResource(R.drawable.picnic_logo);
                tvTitulo.setText(R.string.picnicTitulo);
                tvDescripcion.setText(R.string.picnicDescripcion);
                tvDireccion.setText(R.string.picnicDireccion);
                tvHorarioFecha.setText(R.string.picnicHorario);
                break;
            case 7:
                ivBanner.setImageResource(R.drawable.asiatico_banner);
                ivLogo.setImageResource(R.drawable.asiatico_logo);
                tvTitulo.setText(R.string.chunTitulo);
                tvDescripcion.setText(R.string.chunDescripcion);
                tvDireccion.setText(R.string.chunDireccion);
                tvHorarioFecha.setText(R.string.chunHorario);
                break;
            case 8:
                ivBanner.setImageResource(R.drawable.lalenya_banner);
                ivLogo.setImageResource(R.drawable.lalenya_logo);
                tvTitulo.setText(R.string.leñaTitulo);
                tvDescripcion.setText(R.string.leñaDescripcion);
                tvDireccion.setText(R.string.leñaDireccion);
                tvHorarioFecha.setText(R.string.leñaHorario);
                break;
        }

        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(), ReservarActivity.class);
                startActivity(intent);
            }
        });
    }
}