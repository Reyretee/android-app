package com.acd.makuobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HesapMakinesi extends AppCompatActivity {
    EditText s1, s2;
    TextView sonuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesap_makinesi);
        s1 = findViewById(R.id.editTextNumber);
        s2 = findViewById(R.id.editTextNumber2);
        sonuc = findViewById(R.id.textView7);
    }

    public void btnTopla(View view){
        Double sayi1=Double.parseDouble(s1.getText().toString());
        Double sayi2=Double.parseDouble(s2.getText().toString());
        Double toplam=sayi1+sayi2;
        sonuc.setText(Double.toString(toplam));
    }
    public void btnFark(View view){
        Double sayi1=Double.parseDouble(s1.getText().toString());
        Double sayi2=Double.parseDouble(s1.getText().toString());
        Double fark=sayi1-sayi2;
        sonuc.setText(Double.toString(fark));
    }
    public void btnBol(View view){
        Double sayi1=Double.parseDouble(s1.getText().toString());
        Double sayi2=Double.parseDouble(s1.getText().toString());
        Double bol=sayi1/sayi2;
        sonuc.setText(Double.toString(bol));
    }
    public void btnCarp(View view){
        Double sayi1=Double.parseDouble(s1.getText().toString());
        Double sayi2=Double.parseDouble(s1.getText().toString());
        Double carp=sayi1*sayi2;
        sonuc.setText(Double.toString(carp));
    }
    public void geriDon(View view){
        Intent intent = new Intent(this, Hesaplayici.class);
        startActivity(intent);
    }
}