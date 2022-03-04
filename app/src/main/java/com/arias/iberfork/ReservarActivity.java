package com.arias.iberfork;

import androidx.annotation.AttrRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;

public class ReservarActivity extends AppCompatActivity {
    private int dialogTheme, fullScreenTheme;
    private MaterialDatePicker<?> picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);
        init();
    }

    private void init() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Pickers");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        dialogTheme = resolveOrThrow(this, R.attr.materialCalendarTheme);
        fullScreenTheme = resolveOrThrow(this, R.attr.materialCalendarFullscreenTheme);
    }

    public void openTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void openDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private MaterialDatePicker.Builder<?> setDateBuilder(boolean isDatePicker) {
        int inputMode = MaterialDatePicker.INPUT_MODE_CALENDAR;

        //Date Picker
        if (isDatePicker) {
            MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
            builder.setInputMode(inputMode);
            return builder;
        } else { //Date Range Picker
            MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
            builder.setInputMode(inputMode);
            return builder;
        }
    }

    private void addListener(MaterialDatePicker<?> picker) {
        picker.addOnPositiveButtonClickListener(selection ->
                Toast.makeText(this, picker.getHeaderText(), Toast.LENGTH_SHORT).show()
        );

        picker.addOnNegativeButtonClickListener(selection ->
                Toast.makeText(this, picker.getHeaderText(), Toast.LENGTH_SHORT).show()
        );

        picker.addOnCancelListener(selection ->
                Toast.makeText(this, picker.getHeaderText(), Toast.LENGTH_SHORT).show()
        );
    }

    private int resolveOrThrow(Context context, @AttrRes int attributeResId) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(attributeResId, typedValue, true)) {
            return typedValue.data;
        }
        throw new IllegalArgumentException(context.getResources().getResourceName(attributeResId));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void confirm(View view) {

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Acepta la confirmacion de la reserva ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar();
            }
        });
        dialogo1.show();
    }


    public void cancelar() {
        finish();
    }



    private void aceptar() {
        Intent intent2=new Intent(getApplicationContext(), NavigActivity.class);
        startActivity(intent2);
    }
}