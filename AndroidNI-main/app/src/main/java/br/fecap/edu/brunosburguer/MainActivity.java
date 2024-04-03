package br.fecap.edu.brunosburguer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String escolhaHamburguer;
    private String escolhaBebida;
    private String escolhaBatata;

    private String delivery;

    private RadioButton xSalada, xBacon, xTudo;
    private RadioButton refrigerante, suco, cha;
    private RadioButton batataPq, batataMd, batataGr;

    private Switch swicthDelivery;

    private ImageView imageTroca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xSalada = findViewById(R.id.radioXSalada);
        xBacon = findViewById(R.id.radioXBacon);
        xTudo = findViewById(R.id.radioXTudo);

        refrigerante = findViewById(R.id.radioRefrigerante);
        suco = findViewById(R.id.radioSuco);
        cha = findViewById(R.id.radioChaGelado);

        batataPq = findViewById(R.id.radioBatataPequena);
        batataMd = findViewById(R.id.radiobatataMedia);
        batataGr = findViewById(R.id.radioBatataGrande);

        swicthDelivery = findViewById(R.id.switchDelivery);


        imageTroca = findViewById(R.id.imagemTroca);

        trocaImagem();


    }

    public void trocaImagem(){
        xSalada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageTroca.setImageResource(R.drawable.solanche);
            }
        });
        xBacon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageTroca.setImageResource(R.drawable.solanche);
            }
        });
        xTudo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageTroca.setImageResource(R.drawable.solanche);
            }
        });
        refrigerante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageTroca.setImageResource(R.drawable.sorefrigerante);
            }
        });
        suco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageTroca.setImageResource(R.drawable.sorefrigerante);
            }
        });
        cha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageTroca.setImageResource(R.drawable.sorefrigerante);
            }
        });
        batataPq.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageTroca.setImageResource(R.drawable.sobatata);
            }
        });
        batataMd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageTroca.setImageResource(R.drawable.sobatata);
            }
        });
       batataGr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageTroca.setImageResource(R.drawable.sobatata);
            }
        });

    }



    public void ConfirmarPedido(View view){

        if (swicthDelivery.isChecked()) {

            delivery = "Delivery";

        } else {
            delivery = "Retirada na loja";
        }

        if (xSalada.isChecked()|| xBacon.isChecked()|| xTudo.isChecked()){
            imageTroca.setImageResource(R.drawable.solanche);
        }

        if(xSalada.isChecked()){
            escolhaHamburguer = "XSalada";

        }else if (xBacon.isChecked()){
            escolhaHamburguer = "XBacon";
        }else if (xTudo.isChecked()){
            escolhaHamburguer = "XTudo";
        }else {
            escolhaHamburguer = "Sem lanche";
        }

        if(refrigerante.isChecked()){
            escolhaBebida = "Refrigerante";
        }else if (suco.isChecked()){
            escolhaBebida = "Suco";
        }else if (cha.isChecked()){
            escolhaBebida = "Cha Gelado";
        }else {
            escolhaBebida = "Sem bebida";
        }

        if(batataPq.isChecked()){
            escolhaBatata = "Batata Pequena";
        }else if (batataMd.isChecked()){
            escolhaBatata = "Batata Média";
        }else if (batataGr.isChecked()){
            escolhaBatata = "Batata Grande";
        }else{
            escolhaBatata = "Sem batata";
        }

    }

    public void Resetar(View view){
        xSalada.setChecked(false);
        xBacon.setChecked(false);
        xTudo.setChecked(false);
        refrigerante.setChecked(false);
        suco.setChecked(false);
        cha.setChecked(false);
        batataPq.setChecked(false);
        batataMd.setChecked(false);
        batataGr.setChecked(false);

        imageTroca.setImageResource(R.drawable.logobrunosburguer);


    }

    public void MostrarPedido(View view){
        ConfirmarPedido(view);

        AlertDialog.Builder pedido = new AlertDialog.Builder(this);

        pedido.setTitle("Seu Pedido");
        pedido.setMessage("Hamburguer: " + escolhaHamburguer + "\n " +
                "\nBebida: " + escolhaBebida  + "\n " +
                "\nBatata: " + escolhaBatata + "\n" +
                "\nTipo de entrega: " + delivery);
        pedido.setPositiveButton("sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(
                        getApplicationContext(),
                        "Pedido realizado com sucesso",
                        Toast.LENGTH_SHORT)
                        .show();
                Resetar(view);
                imageTroca.setImageResource(R.drawable.logobrunosburguer);
            }
        });

        pedido.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),
                        "Pedido cancelado",
                        Toast.LENGTH_SHORT)
                        .show();
                Resetar(view);
                imageTroca.setImageResource(R.drawable.logobrunosburguer);
            }
        }) ;


        pedido.create();
        pedido.show();


    }



}