package com.example.starwarsapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.starwarsapp.R;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class AvailablesHeroesActivity extends AppCompatActivity {
    private TextView mTitle;
    private ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availables_heroes);
        mTitle=(TextView)findViewById(R.id.title);
        mListView=(ListView)findViewById(R.id.listView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_logout, menu);
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
        if(id == R.id.action_delete){
            delete();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void delete() {
    }

    private void save() {
    }

    private void signOut(){
        FirebaseAuth.getInstance().signOut();
        Intent intent= new Intent(AvailablesHeroesActivity.this,WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
