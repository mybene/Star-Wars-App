package com.example.starwarsapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.starwarsapp.R;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AvailablesHeroesActivity extends AppCompatActivity {

    private String[] characters =new String[]{"Darth Vader","Luke Skywalker","Princess Leia","Obi-wan Kenobi","Han Solo","Sheev Palpatine",
                            "Yoda","C-3PO","Greedo","Lando Calrissan","Boba Fett","R2-D2","Jabba the Hutt","Mace windu","Wilhuff Tarkin","Qui-Gon Jinn","Finn"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availables_heroes);

        TextView mTitle = (TextView) findViewById(R.id.title);
        ListView mListView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,characters);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            signOut();
            return true;
        }
        if(id== R.id.action_save){
            save();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void save() {

    }

    private void signOut(){
//        FirebaseAuth.getInstance().signOut();
        Intent intent= new Intent(AvailablesHeroesActivity.this,WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
