package com.acd.makuobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String KULLANICI_ADI = "2213409011";
    private static final String SIFRE = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SOSYAL MEDYA GÖRSELLERİNİN TIKLANABİLİR VE YÖNLENDİRME ÖZELLİKLERİ
        //FACEBOOK
        ImageView facebook = findViewById(R.id.facebookView);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Facebook sayfasına yönlendir
                sosyalAc("https://www.facebook.com/makuedutr/?locale=tr_TR");
            }
        });
        //INSTAGRAM
        ImageView instagram = findViewById(R.id.instaView);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instagram sayfasına yönlendir
                sosyalAc("https://www.instagram.com/makuedutr/");
            }
        });
        //YOUTUBE
        ImageView youtube = findViewById(R.id.ytView);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instagram sayfasına yönlendir
                sosyalAc("https://www.youtube.com/c/makuedutr/videos");
            }
        });
        //TWİTTER
        ImageView twitter = findViewById(R.id.twitterView);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instagram sayfasına yönlendir
                sosyalAc("https://twitter.com/makuedutr");
            }
        });

        //GİRİŞ BUTONU
        Button loginbuton = findViewById(R.id.button);
        loginbuton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText usernameEditText = findViewById(R.id.editTextText);
                EditText passwordEditText = findViewById(R.id.editTextTextPassword);

                String enteredUsername = usernameEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                if (checkCredentials(enteredUsername, enteredPassword)) {
                    Intent intent = new Intent(MainActivity.this, Hesaplayici.class);
                    startActivity(intent);
                }
                else{
                    usernameEditText.setError("Kullanıcı adı hatalı.");
                    passwordEditText.setError("Şifre hatalı.");
                }
            }
        });
    }
    private boolean checkCredentials(String username, String password) {
        return username.equals(KULLANICI_ADI) && password.equals(SIFRE);
    }
    private void sosyalAc(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}