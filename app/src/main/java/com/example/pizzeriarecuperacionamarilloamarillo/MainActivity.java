package com.example.pizzeriarecuperacionamarilloamarillo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_PIZZA= "pizza";
    public static final String EXTRA_CANTIDAD= "cantidad";
    EditText edtNombrePizza;
    EditText edtCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNombrePizza = findViewById(R.id.edtNombrePizza);
        edtCantidad = findViewById(R.id.edtCantidad);
    }

    public void Siguiente(View view) {
        String p = String.valueOf(edtNombrePizza.getText());
        if(! p.equalsIgnoreCase("barbacoa") && ! p.equalsIgnoreCase("carbonara"))
        {
            edtNombrePizza.setError("pizza no disponible");
            return;
        }
        String textoCantidad = String.valueOf(edtCantidad.getText());
        int c = Integer.valueOf(textoCantidad);
        if ((c > 5) || (c == 0 )) {
            edtCantidad.setError("cantidad no disponible");
            return;

        }
        Intent intent = new Intent(this, VentaPizza2Activity.class);
        intent.putExtra(EXTRA_PIZZA, p);
        intent.putExtra(EXTRA_CANTIDAD, String.valueOf(c));
        startActivity(intent);

    }
}