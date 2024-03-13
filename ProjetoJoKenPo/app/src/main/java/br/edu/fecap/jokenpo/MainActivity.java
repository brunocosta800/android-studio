package br.edu.fecap.jokenpo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int placarApp = 0;
    int placarJog = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecPedra(View view){
        this.opcaoSelec("Pedra");
    }

    public void selecTesoura(View view){
        this.opcaoSelec("Tesoura");
    }

    public void selecPapel(View view){
        this.opcaoSelec("Papel");
    }

    public void opcaoSelec(String opcaoSelec){

        // Vincula o elemento ImageView ao programa
        ImageView imgResultado = findViewById(R.id.imgBase);
        TextView txtResultado = findViewById(R.id.textResultado);
        TextView textPlacar = findViewById(R.id.textPlacar);


        // Lógica do App que seleciona de forma aleatória uma opção
        int numero = new Random().nextInt(3);
        String [] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];

        // Faz a apresenação da imagem que o App selecionou
        switch (opcaoApp){
            case "Pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imgResultado.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imgResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        // Resultado - App Ganhou
        if(
                    (opcaoApp == "Tesoura" && opcaoSelec == "Papel") ||
                    (opcaoApp == "Pedra" && opcaoSelec == "Tesoura") ||
                    (opcaoApp == "Papel" && opcaoSelec == "Pedra")
        ){
            // App Ganhou
            txtResultado.setText("Você Perdeu!!");
            txtResultado.setTextColor(Color.RED);

            placarApp += 1;
            textPlacar.setText("App: "+placarApp+" Jogador: "+placarJog);
        }

        else if((opcaoSelec == "Tesoura" && opcaoApp == "Papel") ||
                (opcaoSelec == "Pedra" && opcaoApp == "Tesoura") ||
                (opcaoSelec == "Papel" && opcaoApp == "Pedra")
        ){
            // Jogador Ganhou
            txtResultado.setText("Você Ganhou!!");
            txtResultado.setTextColor(Color.GREEN);
            placarJog += 1;
            textPlacar.setText("App: "+placarApp+" Jogador: "+placarJog);
        }

        else{
            // Empate
            txtResultado.setText("Empate!!");
            txtResultado.setTextColor(Color.GRAY);
            textPlacar.setText("App: "+placarApp+" Jogador: "+placarJog);
        }
    }
}