package com.acd.makuobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hesaplayici extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesaplayici);
    }
    public void VizeFinalGecisYap(View view){
        Intent intent = new Intent(this, VizeFinal.class);
        startActivity(intent);
    }
    public void HesapMakinesiGecisYap(View view){
        Intent intent = new Intent(this, HesapMakinesi.class);
        startActivity(intent);
    }
    public void SaatGecisYap(View view){
        Intent intent = new Intent(this, Saat.class);
        startActivity(intent);
    }
}