package br.edu.fecap.niparte2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText observacao, endereco;
    private Switch delivery, cartao;
    private RadioButton portuguesa, calabresa, frango, refrigerante, suco, cha;

    private String sabor, bebida, pagamento, entrega, ponto;

    private SeekBar seekBarPonto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observacao = findViewById(R.id.inputObservacao);
        endereco = findViewById(R.id.inputEndereco);
        delivery = findViewById(R.id.switchDelivery);
        cartao = findViewById(R.id.switchCartao);
        portuguesa = findViewById(R.id.radioPortuguesa);
        calabresa = findViewById(R.id.radioCalabresa);
        frango = findViewById(R.id.radioFrango);
        refrigerante = findViewById(R.id.radioRefrigerante);
        suco = findViewById(R.id.radioSuco);
        cha = findViewById(R.id.radioCha);
        seekBarPonto = findViewById(R.id.seekBarPonto);
    }

    public void enviarPedido(View view){
        if (portuguesa.isChecked()){
            sabor = "Portuguesa";
        }
        else if(calabresa.isChecked()){
            sabor = "Calabresa";
        }
        else if(frango.isChecked()){
            sabor = "Frango com Catupiry";
        }

        if (refrigerante.isChecked()){
            bebida = "Refrigerante";
        }
        else if (suco.isChecked()){
            bebida = "Suco";
        }
        else if (cha.isChecked()){
            bebida = "Chá";
        }
        else{
            bebida = "Sem bebida";
        }

        if(cartao.isChecked()){
            pagamento = "Cartão";
        }
        else{
            pagamento = "Dinheiro";
        }

        if(delivery.isChecked()){
            entrega = "Delivery";
        }
        else{
            entrega = "Retirada na loja";
        }

        if (seekBarPonto.getProgress() < 5){
            ponto = "Massa mal passada";
        }
        else if (seekBarPonto.getProgress() == 5){
            ponto = "Massa no ponto";
        }
        else if (seekBarPonto.getProgress() > 5){
            ponto = "Massa bem passada";
        }
    }

    public void mostrarPedido (View view){
        enviarPedido(view);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Resumo do Pedido:");
        dialog.setMessage("Sabor: "+ sabor+"\nBebida: "+bebida+"\nTipo de Pagamento: "+pagamento+
                "\nTipo de Entrega: "+entrega+"\nEndereço: "+endereco.getText()+
                "\nObservação: "+observacao.getText()+"\nPonto da massa: "+ponto);

        dialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Pedido confirmado", Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Pedido cancelado", Toast.LENGTH_LONG).show();
            }
        });

        dialog.create();
        dialog.show();
    }

    public void resetar(View view){
        observacao.setText("");
        endereco.setText("");
        delivery.setChecked(false);
        cartao.setChecked(false);
        portuguesa.setChecked(false);
        calabresa.setChecked(false);
        frango.setChecked(false);
        refrigerante.setChecked(false);
        suco.setChecked(false);
        cha.setChecked(false);
        seekBarPonto.setProgress(0);
    }
}