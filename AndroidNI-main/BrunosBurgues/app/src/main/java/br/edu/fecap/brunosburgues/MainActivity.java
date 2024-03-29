package br.edu.fecap.brunosburgues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private Switch switchDelivery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchDelivery = findViewById(R.id.switchDelivery);

        switchMuda();
    }

    public void switchMuda(){
        switchDelivery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switchDelivery.setText("Delivery");
                }
                else{
                    switchDelivery.setText("Pegue na loja");
                }
            }
        });
    }
}