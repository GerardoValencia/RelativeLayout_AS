package edu.iest.relativelayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bnCambiar = findViewById(R.id.bnCambiar);
        EditText etCanal = findViewById(R.id.etCanal);
        TextView tvCanal = findViewById(R.id.tvCanal);
        TextView tvLegendCanal = findViewById(R.id.tvLegendCanal);
        Spinner spinner = findViewById(R.id.spVtubers);
        ImageView imageView = findViewById(R.id.ivVtuber);
        ivVtuber = findViewById(R.id.ivVtuber);

        //Cambiar color fondo y texto por codigo
        tvCanal.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200));
        tvCanal.setTextColor(ContextCompat.getColor(this, R.color.white));

        //Otras opciones
        tvLegendCanal.setBackgroundColor(Color.parseColor(("#DDE426")));
        tvLegendCanal.setBackgroundColor(Color.DKGRAY);

        spinner.setOnItemSelectedListener(this);
        bnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aquí la lógica que hacer al dar clic
                //obtendremos el valor del edittext y lo asignaremos al textview inferior
                String texto = etCanal.getText().toString();
                tvCanal.setText(texto);
                Toast.makeText(getApplicationContext(), "Texto Actualizado", Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this, "El valor era "+texto, Toast.LENGTH_LONG).show();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear la alerta
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("¿Desea continura?");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Ir a la segunda pantalla
                        Intent i = new Intent(MainActivity.this, DatosActivity.class);
                        i.putExtra("parametroString", "texto de prueba");
                        i.putExtra("parametroInt", 123);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
                // Intent i = new Intent( MainActivity.this, DatosActivity.class);
                // startActivity(i);
            }
        });
    }

    private ImageView ivVtuber;
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {
        String vtuber = adapterView.getItemAtPosition(posicion).toString();
        Snackbar.make(adapterView, "Vtuber seleccionada "+vtuber, Snackbar.LENGTH_LONG).show();

        if(posicion == 0) {
            ivVtuber.setImageResource(R.drawable.vtuber1);
        }else if(posicion == 1) {
            ivVtuber.setImageResource(R.drawable.vtuber2);
        }else{
            ivVtuber.setImageResource(R.drawable.vtuber3);
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}