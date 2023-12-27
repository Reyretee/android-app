package com.acd.makuobs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class VizeFinal extends AppCompatActivity {

    EditText vize,finalnot;
    TextView ortalama, harfn, dortluk;
    ImageView yuzImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vize_final);

        vize = findViewById(R.id.s1);
        finalnot= findViewById(R.id.s2);
        ortalama = findViewById(R.id.ort);
        harfn = findViewById(R.id.harf);
        dortluk = findViewById(R.id.dortlu);
        yuzImage = findViewById(R.id.imageView4);
    }

    public void Hesapla(View view){
        float sa1=0, sa2=0;
        sa1=Float.parseFloat(vize.getText().toString());
        sa2=Float.parseFloat((finalnot.getText().toString()));
        float sonuc=OrtalamaHesaplama(sa1,sa2);
        ortalama.setText(Float.toString(sonuc));
        harfn.setText(HarfNotuHesaplama(sonuc));
        dortluk.setText(HarfNotuHesaplamaIki(sonuc));
        vizeKontrol();
        finalKontrol();
    }
    private void vizeKontrol() {
        String vizeNotuStr = vize.getText().toString();
        double vizeNotu = Double.parseDouble(vizeNotuStr);
        if (vizeNotu < 0 || vizeNotu > 100) {
            vize.setError("Notunuz 0-100 arasında olmalıdır.");
        } else {
            vize.setError(null);
        }
    }

    private void finalKontrol() {
        String finalNotuStr = finalnot.getText().toString();
        double finalNotu = Double.parseDouble(finalNotuStr);
        if (finalNotu < 0 || finalNotu > 100) {
            finalnot.setError("Notunuz 0-100 arasında olmalıdır.");
        } else {
            finalnot.setError(null);
        }
    }

    public float OrtalamaHesaplama(float a, float b)
    {
        return (float) (a*0.4 + b*0.6);
    }

    @SuppressLint("SuspiciousIndentation")
    public String HarfNotuHesaplama(float ortalama){
        if (ortalama > 100){
            return "Hata";
        }
        else if (ortalama >= 90){
            yuzImage.setImageResource(R.drawable.aanot);
            return "4.0";
        }
        else if (ortalama >=85){
            yuzImage.setImageResource(R.drawable.banot);
            return "3.5";
        }
        else if (ortalama >=80){
            yuzImage.setImageResource(R.drawable.bbnot);
            return "3.0";
        }
        else if (ortalama >=75){
            yuzImage.setImageResource(R.drawable.cbnot);
            return "2.5";
        }
        else if (ortalama >=70){
            yuzImage.setImageResource(R.drawable.ccnot);
            return "2.0";
        }
        else if (ortalama >=65){
            yuzImage.setImageResource(R.drawable.dcnot);
            return "1.5";
        }
        else if (ortalama >=60){
            yuzImage.setImageResource(R.drawable.ddnot);
            return "1.0";
        }
        else if (ortalama >=0)
            yuzImage.setImageResource(R.drawable.ffnot);
        return "0.5";
    }
    public String HarfNotuHesaplamaIki(float ortalama){
        if (ortalama > 100){
            return "Hata";
        }
        else if (ortalama >= 90){
            return "AA";
        }
        else if (ortalama >=85){
            return "BA";
        }
        else if (ortalama >=80){
            return "BB";
        }
        else if (ortalama >=75){
            return "CB";
        }
        else if (ortalama >=70){
            return "CC";
        }
        else if (ortalama >=65){
            return "DC";
        }
        else if (ortalama >=60){
            return "DD";
        }
        else if (ortalama >=0){
            return "FF";
        }
        return null;
    }
    public void geriDon(View view){
        Intent intent = new Intent(this, Hesaplayici.class);
        startActivity(intent);
    }

}