package com.example.dialogpers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listViewDialoper;
    private ArrayAdapter<String> dialogperAdapter;
    private String[] dialogList = {"Dialogo simple",
    "Dialogo con lista",
    "Dialogo con Radios"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewDialoper = findViewById(R.id.list_Diagloper);
        dialogperAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
        ,dialogList);
        listViewDialoper.setAdapter(dialogperAdapter);
        listViewDialoper.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                AlertDialog dialogo = null;
                switch (posicion){
                    case 0: dialogo = crearDialogoBasico(); break;
                    case 1: dialogo = crearDialogoconLista();break;
                    case 2: dialogo = crearDialogoconRadios(); break;
                    default: dialogo = crearDialogoBasico(); break;
                }
                dialogo.show();
            }
        });

    }

    private AlertDialog crearDialogoconRadios() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] sequences = new CharSequence[4];
        sequences[0] = "SOLTERO/A";
        sequences[1] = "CASADO/A";
        sequences[2] = "DIVORCIADO/A";
        sequences[3] = "VIUDO/A";


        builder.setTitle("Ejemplo de Dialogo Basico ")
                .setSingleChoiceItems(sequences,0,(dialogInterface, i) -> {
                    Toast.makeText(
                            getApplicationContext(),
                            "Seleccionaste:" + sequences[i],
                            Toast.LENGTH_LONG )
                            .show();
                });
        return builder.create();

    }

    private AlertDialog crearDialogoconLista() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] sequences = new CharSequence[3];
        sequences[0] = "Mango";
        sequences[1] = "Melon";
        sequences[2] = "Sandia";

        builder.setTitle("Ejemplo de Dialogo Basico ")
                .setItems(sequences,(dialogInterface, i) -> {
                    Toast.makeText(
                            getApplicationContext(),
                            "Seleccionaste:" + sequences[i],
                            Toast.LENGTH_LONG )
                            .show();
        });
        return builder.create();
    }


    private AlertDialog crearDialogoBasico() {
        AlertDialog.Builder builder = new  AlertDialog.Builder(this);
        builder
                .setTitle("Ejemplo de Dialogo Basico ")
                    .setMessage("Es un ejemplo para crear dialogos")
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),"Presiono Aceptar", Toast.LENGTH_LONG ).show();

                        }
                    }).setNegativeButton("Cancelar",(dialogInterface, i) -> {
                            Toast.makeText(getApplicationContext(),"Presiono Cancelar", Toast.LENGTH_LONG ).show();
        });

        return builder.create();

    }
}