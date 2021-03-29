package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

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
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
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

