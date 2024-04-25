package br.edu.fecap.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class telaCalcular extends AppCompatActivity {

    private TextView txtSalarioBruto, txtInss, txtFgts, txtSalarioLiquido;

    private String salario;

    private double descontoInss, nSalario, descontoFgts, salarioLiquido;

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

        txtFgts = findViewById(R.id.txtFgts);
        String fgts = String.valueOf(calcularFgts(nSalario));
        txtFgts.setText(fgts);

        String inss = String.valueOf(calcularInss(nSalario));
        txtInss.setText(inss);

        txtSalarioLiquido = findViewById(R.id.txtSalarioLiquido);
        String sL = String.valueOf(calcularSalarioLiquido(nSalario));
        txtSalarioLiquido.setText(sL);
    }

    public double calcularInss(double nSalario){
        if(nSalario <= 1412){
            return descontoInss = (nSalario * 0.075);
        }
        else if(nSalario >= 1412.01 && nSalario <= 2666.68){
            return descontoInss = ((nSalario - 1412) * 0.09) + 105.9;
        }
        else if(nSalario >= 2666.69 && nSalario <=  4000.03){
            return descontoInss = ((nSalario - 2666.68) * 0.12) + 112.92 + 105.9;
        }
        else if(nSalario >= 4000.04 && nSalario <= 7786.02){
            return descontoInss = ((nSalario - 4000.03) * 0.14) + 160 + 112.92 + 105.9;
        }
        else if(nSalario >= 7786.03){
            return descontoInss = 530.04 + 160 + 112.92 + 105.9;
        }

        return 0;
    }

    public double calcularFgts(double nSalario){
        return descontoFgts = nSalario * 0.08;
    }

    public double calcularSalarioLiquido(double nSalario){
        return salarioLiquido = nSalario - (calcularInss(nSalario) + calcularFgts(nSalario));
    }

    public void voltarTela(View view){
        finish();
    }

    private String arredondar(double valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(salario);
    }
}