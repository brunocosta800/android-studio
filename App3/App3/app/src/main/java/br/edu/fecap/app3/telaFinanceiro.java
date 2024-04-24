package br.edu.fecap.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class telaFinanceiro extends AppCompatActivity {

    private Button btnCalcular, btnVoltar;

    private String salario;

    private TextInputEditText salarioBruto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_financeiro);

        salarioBruto = findViewById(R.id.salarioBruto);
    }


    public void voltarTela(View view){
        finish();
    }

    public void irTelaCalcular(View view){
        Intent irTelaCalcular = new Intent(this, telaCalcular.class);
        String salario = salarioBruto.getText().toString();
        irTelaCalcular.putExtra("salarioBruto", salario);

        startActivity(irTelaCalcular);
    }

    public void limparSalario(View view){
        salarioBruto.setText("");
    }
}