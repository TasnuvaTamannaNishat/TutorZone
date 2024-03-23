package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splash extends AppCompatActivity {
 TextView appname;
    LottieAnimationView lottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
   appname=findViewById(R.id.appname);
   lottie = findViewById(R.id.lottie);

   appname.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
        lottie.animate().translationY(2000).setDuration(2700).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
       @Override
       public void run() {
           FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
           if(currentUser==null){
               startActivity(new Intent(splash.this,MainActivity.class));
           }
           else{
               startActivity(new Intent(splash.this,sixcardbackup.class));
           }
  }
   },5000);



    }
}