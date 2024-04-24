package br.edu.fecap.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class notaFinal extends AppCompatActivity {

    private String po, ni1, ni2, pi;

    private TextView txtNotaFinal, txtStatus;

    private double notaPo, notaNi1, notaNi2, notaPi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_final);

        txtNotaFinal = findViewById(R.id.txtNotaFinal);
        txtStatus = findViewById(R.id.txtStatus);


        double nF = calcularNota();
        txtNotaFinal.setText(String.valueOf(nF));

        String status = definirStatus(nF);
        txtStatus.setText(status);
    }

    public double calcularNota(){
        po = getIntent().getStringExtra("notaPo");
        ni1 = getIntent().getStringExtra("notaNi1");
        ni2 = getIntent().getStringExtra("notaNi2");
        pi = getIntent().getStringExtra("notaPi");

        notaPo = Double.valueOf(po).doubleValue();
        notaNi1 = Double.valueOf(ni1).doubleValue();
        notaNi2 = Double.valueOf(ni2).doubleValue();
        notaPi = Double.valueOf(pi).doubleValue();

        double notaFinal = (notaPo * 0.5) + (notaNi1 * 0.1) + (notaNi2 * 0.1) + (notaPi * 0.3);
        return notaFinal;
    }

    public String definirStatus(Double nota){
        String status;
        if(nota < 6){
            status = "Reprovado";
            return status;
        }
        else if(nota > 6){
            status = "Aprovado";
            return status;
        }

        return "Erro";
    }

    public void voltarTela(View view){
        finish();
    }
}