package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton radioDeposito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void comprobarModoPago(View v){
        if (radioDeposito.isChecked()){
            final String text = "Comprobar ubicación del usuario";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
    }
}