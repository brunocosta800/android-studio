package br.edu.fecap.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class telaCalcular extends AppCompatActivity {

    private TextView txtSalarioBruto, txtInss;

    private String salario;

    private double descontoInss, nSalario;

    private Button btnVoltarFinanceiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calcular);

        txtSalarioBruto = findViewById(R.id.txtSalarioBruto);
        btnVoltarFinanceiro = findViewById(R.id.btnVoltarFinanceiro);
        txtInss = findViewById(R.id.txtInss);

        salario = getIntent().getStringExtra("salarioBruto");
        nSalario = Double.valueOf(salario).doubleValue();
        txtSalarioBruto.setText(salario);
    }

    public void calcularInss(){
        if(nSalario <= 1412){
            descontoInss = (nSalario * 0.075);
        }
        else if(nSalario > 1412 && nSalario <= 2666.68){
            descontoInss = (nSalario * 0.09);
        }
        else if(nSalario > 2666.68 && nSalario <=  4000.03){
            descontoInss = (nSalario * 0.12);
        }
    }

    public void voltarTela(View view){
        finish();
    }
}