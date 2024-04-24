package br.edu.fecap.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Imc extends AppCompatActivity {

    private TextView txtPeso, txtAltura, txtImc, txtClassificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        txtImc = findViewById(R.id.txtImc);
        txtClassificacao = findViewById(R.id.txtClassificacao);

        String peso = getIntent().getStringExtra("Peso");
        String altura = getIntent().getStringExtra("Altura");

        double nPeso = Double.valueOf(peso).doubleValue();
        double nAltura = Double.valueOf(altura).doubleValue();

        double resultadoImc = calcularImc(nPeso, nAltura);
        String Imc = String.valueOf(resultadoImc);

        String resultadoClassificacao = classificarImc(resultadoImc);

        txtPeso.setText(peso);
        txtAltura.setText(altura);
        txtImc.setText(Imc);
        txtClassificacao.setText(resultadoClassificacao);
    }

    public double calcularImc(double p, double a){
        double imc = p / (a * a);
        return imc;
    }

    public String classificarImc(double i){
        String classificacao;
        if(i <= 18.5){
            classificacao = "Baixo Peso";
            return classificacao;
        }
        else if(i > 18.5 && i <= 24.9){
            classificacao = "Peso Adequado";
            return classificacao;
        }
        else if(i >= 25 && i <= 29.9){
            classificacao = "Sobrepeso";
            return classificacao;
        }
        else if(i >= 30 && i <= 34.9){
            classificacao = "Obesidade Grau 1";
            return classificacao;
        }
        else if(i >= 35 && i <= 39.9){
            classificacao = "Obesidade Grau 2";
            return classificacao;
        }
        else if(i >= 40){
            classificacao = "Obesidade Extrema";
            return classificacao;
        }

        return "Erro";
    }

    public void voltarTela(View view){
        finish();
    }
}