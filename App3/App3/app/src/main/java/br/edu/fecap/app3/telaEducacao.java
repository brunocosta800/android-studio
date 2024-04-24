package br.edu.fecap.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class telaEducacao extends AppCompatActivity {

    private TextInputEditText notaPo, notaNi1, notaNi2, notaPi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_educacao);

        notaPo = findViewById(R.id.inputPo);
        notaNi1 = findViewById(R.id.inputNi1);
        notaNi2 = findViewById(R.id.inputNi2);
        notaPi = findViewById(R.id.inputPi);
    }

    public void irTelaNotaFinal(View view){
        Intent irTelaNotaFinal = new Intent(this, notaFinal.class);
        String po = notaPo.getText().toString();
        String ni1 = notaNi1.getText().toString();
        String ni2 = notaNi2.getText().toString();
        String pi = notaPi.getText().toString();
        irTelaNotaFinal.putExtra("notaPo", po);
        irTelaNotaFinal.putExtra("notaNi1", ni1);
        irTelaNotaFinal.putExtra("notaNi2", ni2);
        irTelaNotaFinal.putExtra("notaPi", pi);

        startActivity(irTelaNotaFinal);
    }

    public void voltarTela(View view){
        finish();
    }

    public void limparNotas(View view){
        notaPo.setText("");
        notaNi1.setText("");
        notaNi2.setText("");
        notaPi.setText("");
    }

}