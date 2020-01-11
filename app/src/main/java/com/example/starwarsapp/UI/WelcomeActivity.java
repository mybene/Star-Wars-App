package com.example.starwarsapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.starwarsapp.R;



public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

  TextView available;
  TextView newHero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

      available=(TextView)findViewById(R.id.allList);
      newHero=(TextView)findViewById(R.id.newHero) ;
        available.setOnClickListener(this);
        newHero.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v==available){
            Intent intent= new Intent(WelcomeActivity.this,AvailablesHeroesActivity.class);
            startActivity(intent);
        }

        if(v==newHero){
            Intent intent= new Intent(WelcomeActivity.this,NewHeroActivity.class);
            startActivity(intent);
        }
    }
}
