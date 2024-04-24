package br.edu.fecap.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnFinanceiro, btnEducacao, btnSaude, btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFinanceiro = findViewById(R.id.btnFinanceiro);
        btnEducacao = findViewById(R.id.btnEducacao);
        btnSaude = findViewById(R.id.btnSaude);
        btnInfo = findViewById(R.id.btnInfo);
    }

    public void irFinanceiro(View view){
        Intent financeiro = new Intent(this, telaFinanceiro.class);
        startActivity(financeiro);
    }

    public void irEducacao(View view){
        Intent educacao = new Intent(this, telaEducacao.class);
        startActivity(educacao);
    }

    public void irSaude(View view){
        Intent saude = new Intent(this, telaSaude.class);
        startActivity(saude);
    }

    public void irInfo(View view){
        Intent info = new Intent(this, telaInfo.class);
        startActivity(info);
    }
}