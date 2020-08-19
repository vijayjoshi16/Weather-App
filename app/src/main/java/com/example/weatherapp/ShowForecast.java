package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowForecast extends AppCompatActivity {
    TextView tvTemp,tvDesc,tvHeader;
    ImageView weatherIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_forecast);
        tvTemp=findViewById(R.id.tvTemp);
        tvDesc=findViewById(R.id.tvDesc);
        tvHeader=findViewById(R.id.tvHeader);
        weatherIcon=findViewById(R.id.weatherIcon);
        ConstraintLayout constraintLayout=findViewById(R.id.forecastLayout);
        String temp=getIntent().getStringExtra("TEMP");
        String description=getIntent().getStringExtra("DESC");
        String icon=getIntent().getStringExtra("ICON");
        tvTemp.setText(temp);
        tvDesc.setText(description);
        tvHeader.setText("Current Weather in "+getIntent().getStringExtra("PLACE"));
        final Animation animation1= AnimationUtils.loadAnimation(ShowForecast.this,R.anim.fly_in);
        final Animation animation2= AnimationUtils.loadAnimation(ShowForecast.this,R.anim.fly_in2);
        final Animation animation3= AnimationUtils.loadAnimation(ShowForecast.this,R.anim.fly_in3);
        if(icon.equals("01d")||icon.equals("01n")){
            constraintLayout.setBackgroundResource(R.drawable.sunny);
        }else if(icon.equals("02d")||icon.equals("02n")){
            constraintLayout.setBackgroundResource(R.drawable.light_clouds);
        }else if(icon.equals("03d")||icon.equals("03n")){
            constraintLayout.setBackgroundResource(R.drawable.cloudy);
        }else if(icon.equals("04d")||icon.equals("04n")){
            constraintLayout.setBackgroundResource(R.drawable.cloudy2);
        }else if(icon.equals("09d")||icon.equals("09n")){
            constraintLayout.setBackgroundResource(R.drawable.light_rain);
        }else if(icon.equals("10d")||icon.equals("10n")){
            constraintLayout.setBackgroundResource(R.drawable.rain);
        }else if(icon.equals("11d")||icon.equals("11n")){
            constraintLayout.setBackgroundResource(R.drawable.thunderstorm);
        }else if(icon.equals("13d")||icon.equals("13n")){
            constraintLayout.setBackgroundResource(R.drawable.snow);
        }else{
            constraintLayout.setBackgroundResource(R.drawable.default_img);
        }
        tvHeader.startAnimation(animation1);
        tvTemp.startAnimation(animation2);
        tvDesc.startAnimation(animation3);
    }
    public void onBackPressed(){
        startActivity(new Intent(ShowForecast.this,HomePageActivity.class));
    }
}
