package com.acd.makuobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Saat extends AppCompatActivity {

    private TextView textViewSaat, textViewTarih;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saat);

        textViewSaat = findViewById(R.id.textView8);
        textViewTarih = findViewById(R.id.textView11);
        handler = new Handler(Looper.getMainLooper());
        updateClock();
    }
    private void updateClock() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                // Şu anki saat bilgisini alır
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String currentTime = timeFormat.format(calendar.getTime());
                String currentDate = dateFormat.format(calendar.getTime());

                textViewTarih.setText(currentDate);

                textViewSaat.setText(currentTime);

                // Her saniye işlemi tekrarlar
                handler.postDelayed(this, 1000);
            }
        });
    }
    public void geriDon(View view){
        Intent intent = new Intent(this, Hesaplayici.class);
        startActivity(intent);
    }
}