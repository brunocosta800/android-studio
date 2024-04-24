package br.edu.fecap.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class telaSaude extends AppCompatActivity {

    private TextInputEditText inputPeso, inputAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_saude);

        inputPeso = findViewById(R.id.inputPeso);
        inputAltura = findViewById(R.id.inputAltura);
    }

    public void irTelaImc(View view){
        Intent irTelaImc = new Intent(this, Imc.class);
        String peso = inputPeso.getText().toString();
        String altura = inputAltura.getText().toString();
        irTelaImc.putExtra("Peso", peso);
        irTelaImc.putExtra("Altura", altura);
        startActivity(irTelaImc);
    }

    public void voltarTela(View view){
        finish();
    }

    public void limparImc(View view){
        inputPeso.setText("");
        inputAltura.setText("");
    }
}