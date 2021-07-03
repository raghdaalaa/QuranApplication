package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.quranapplication.language.languageSelect;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // splash screen
Thread thread =new Thread(){

    @Override
    public void run() {
        try {
            sleep(3000);
            Intent intent=new Intent(SplashScreen.this,languageSelect.class);
           startActivity(intent);
            finish();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
};
thread.start();

    }
}

