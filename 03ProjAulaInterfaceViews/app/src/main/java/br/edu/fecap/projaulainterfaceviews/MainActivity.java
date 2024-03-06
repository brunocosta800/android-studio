package br.edu.fecap.projaulainterfaceviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view){
        TextInputEditText campoPO = findViewById(R.id.inputPO);
        TextInputEditText campoPI = findViewById(R.id.inputPI);
        TextInputEditText campoNI = findViewById(R.id.inputNI);
        TextView textoResultado = findViewById(R.id.textResultado);


        // Cria o objeto nome e idade, recupera (get) o texto e converte para String;

        String notaPO = campoPO.getText().toString();
        String notaPI = campoPI.getText().toString();
        String notaNI = campoPI.getText().toString();

        double PO = Double.valueOf(notaPO).doubleValue();
        double PI = Double.valueOf(notaPI).doubleValue();
        double NI = Double.valueOf(notaNI).doubleValue();

        // Exibe no campo Resultado o nome digitado;
        textoResultado.setText("Sua média final é: " + (notaFinal(PO, PI, NI)));

    }

    public String notaFinal(double notaPO, double notaPI, double notaNI){
        double notaFinal = 0;

        notaFinal = (notaPO + notaPI + notaNI)/3;

        return String.valueOf(notaFinal).toString();
    }
}