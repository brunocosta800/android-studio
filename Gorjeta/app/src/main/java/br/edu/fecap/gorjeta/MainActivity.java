package br.edu.fecap.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarGorjeta;
    private TextView textoGorjeta;
    private EditText editValor;
    private TextView textoPorcentagem;
    private TextView textoTotal;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textoGorjeta = findViewById(R.id.textoGorjeta);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);
        textoPorcentagem = findViewById(R.id.textoPorcentagem);
        textoTotal = findViewById(R.id.textoTotal);

        porcentagemGorjeta();
    }

    public void porcentagemGorjeta(){
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textoPorcentagem.setText(progress + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){
        String valorRecuperado = editValor.getText().toString();
        if(valorRecuperado == null || valorRecuperado.equals("")){

        }else{
            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = valorDigitado*(porcentagem/100);
            double total = gorjeta + valorDigitado;

            textoGorjeta.setText("R$ "+gorjeta);
            textoTotal.setText("R$ "+total);
        }
    }
}