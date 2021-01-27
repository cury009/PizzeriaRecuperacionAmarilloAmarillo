package com.example.pizzeriarecuperacionamarilloamarillo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class VentaPizza2Activity extends AppCompatActivity {
    private static final String EXTRA_IVA= "IVA";
    private static final String EXTRA_TOTAL = "total";
    private static final String EXTRA_SALDOCUENTA= "SaldoCuenta";

    TextView txt_resultado_cuenta;
    TextView txt_resultado_precio;
    TextView txt_resultado_iva;
    TextView txt_resultado_descuento;
    TextView txt_resultado_total;

    double preciop = 0.0;
    double precioiva= 0.0;
    double cuenta=0.0;
    double preciototal =0.0;
    double preciobase = 0.0;
    double descuento = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DecimalFormat df = new DecimalFormat("#.00");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_pizza2);
        txt_resultado_cuenta = findViewById(R.id.txt_resultado_cuenta);
        txt_resultado_descuento = findViewById(R.id.txt_resultado_descuento);
        txt_resultado_iva = findViewById(R.id.txt_resultado_iva);
        txt_resultado_precio = findViewById(R.id.txt_resultado_precio);
        txt_resultado_total = findViewById(R.id.txt_resultado_total);

        Intent intent = getIntent();
        String p = intent.getStringExtra(MainActivity.EXTRA_PIZZA);
        String c = intent.getStringExtra(MainActivity.EXTRA_CANTIDAD);
        System.out.println(c);

        //String cantidad = String.valueOf(c);
        int cantidadPizzas = Integer.valueOf(c);




        //-------------------------------------------------------------------------------------------
        if (p.equalsIgnoreCase("barbacoa")) {
            preciop = 5.0;
        }
        if (p.equalsIgnoreCase("carbonara")) {
            preciop = 4.5;
        }
        preciobase = preciop * cantidadPizzas;
        txt_resultado_precio.setText(String.valueOf(preciobase));





//-------------------------------------------------------------------------------------------
        precioiva = (preciobase * 0.21);
        String iva =  df.format(precioiva) + "€";
        txt_resultado_iva.setText(iva);
        //-------------------------------------------------------------------------------------------
        String total =  df.format((preciobase + precioiva ) * 1.21) + "€";
        txt_resultado_total.setText(total);
        //-------------------------------------------------------------------------------------------


    }

    public void utilizarSaldo(View view) {
        DecimalFormat df = new DecimalFormat("#.00");
        //String saldo = String.valueOf(txt_resultado_cuenta.getText());
       /* if(cuenta ==15.00) {
            String iva =  df.format(precioiva) + "€";
            txt_resultado_iva.setText(iva);

            String total =  df.format(((preciobase + precioiva)- cuenta) * 1.21) + "€";
            txt_resultado_total.setText(total);
            cuenta = (cuenta-preciobase);

        }*/

    }
}