package com.example.starwarsapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.starwarsapp.R;
import android.widget.ListView;
import android.widget.TextView;

public class AvailablesHeroesActivity extends AppCompatActivity {
    private TextView mTitle;
    private ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availables_heroes);
    }
}
