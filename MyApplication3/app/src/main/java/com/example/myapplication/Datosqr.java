package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

public class Datosqr extends AppCompatActivity {
    EditText cantidadEditText, fechaEditText, numeroParteEditText, revisionEditText, jobEditText, localizacionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datosqr);

        cantidadEditText = findViewById(R.id.cantidad_edit_text);
        fechaEditText = findViewById(R.id.fecha_edit_text);
        numeroParteEditText = findViewById(R.id.numero_parte_edit_text);
        revisionEditText = findViewById(R.id.revision_edit_text);
        jobEditText = findViewById(R.id.job_edit_text);
        localizacionEditText = findViewById(R.id.localizacion_edit_text);

        Button guardarButton = findViewById(R.id.guardar_button);
        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarDatos();
            }
        });

        scanearCodigoQR();
    }

    private void scanearCodigoQR() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Escanee el código QR");
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                String qrCode = result.getContents();
                llenarCampos(qrCode);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void llenarCampos(String qrCode) {
        // Aquí debes implementar la lógica para llenar los campos correspondientes
        // del formulario según el código QR escaneado
    }

    private void guardarDatos() {
        String cantidad = cantidadEditText.getText().toString().trim();
        String fecha = fechaEditText.getText().toString().trim();
        String numeroParte = numeroParteEditText.getText().toString().trim();
        String revision = revisionEditText.getText().toString().trim();
        String job = jobEditText.getText().toString().trim();
        String localizacion = localizacionEditText.getText().toString().trim();

        // Aquí debes implementar la lógica para guardar los datos en la base de datos
        // o hacer lo que desees con ellos

        // Luego de guardar los datos, regresamos a la actividad anterior
        onBackPressed();
    }
}