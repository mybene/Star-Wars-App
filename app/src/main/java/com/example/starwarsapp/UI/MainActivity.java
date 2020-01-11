package com.example.starwarsapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.starwarsapp.R;


public class MainActivity extends AppCompatActivity {
    ImageButton welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome=(ImageButton)findViewById(R.id.karibu) ;

        Animation flash= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        welcome.startAnimation(flash);

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"WElcome!!!",Toast.LENGTH_LONG).show();

                Intent intent= new Intent(MainActivity.this,WelcomeActivity.class);
                startActivity(intent);
            }
        });




    }
}
