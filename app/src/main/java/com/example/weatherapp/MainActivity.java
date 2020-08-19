package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView=findViewById(R.id.logo);
        final TextView textView=findViewById(R.id.description);
        final Animation animation1= AnimationUtils.loadAnimation(MainActivity.this,R.anim.fly_in);
        final Animation animation2= AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade_in);
        imageView.startAnimation(animation2);
        textView.startAnimation(animation1);
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,HomePageActivity.class));
            }
        },2000);

    }
}
