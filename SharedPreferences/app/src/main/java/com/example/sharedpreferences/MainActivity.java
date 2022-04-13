package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail;
    private Button btnGuardar;
    private TextView tvEmail;
    private static final String MAIL = "mail";
    private static final String PREFERENCIAS ="datos";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = findViewById(R.id.et_email);
        btnGuardar = findViewById(R.id.btn_guardar);
        tvEmail = findViewById(R.id.tv_Email);

        SharedPreferences preferences = getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
        tvEmail.setText(preferences.getString(MAIL,"No existe email en las preferencias"));

        btnGuardar.setOnClickListener(view -> {
            ejecutar();
        });


    }

    private void ejecutar() {
        String correo = etEmail.getText().toString();
        if (correo.length() > 0 ){
        SharedPreferences preferences = getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(MAIL, correo);
        editor.commit();
            Toast.makeText(this,"Email" + correo +
                    "guardado", Toast.LENGTH_LONG)
                        .show();
        }
    }
}