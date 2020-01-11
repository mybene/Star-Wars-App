package com.example.starwarsapp.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.starwarsapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class AvailablesHeroesActivity extends AppCompatActivity {

    private ProgressDialog mAuthProgressDialog;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

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

                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.listView:
                            PopupMenu popup = new PopupMenu(context, view);
                            popup.getMenuInflater().inflate(R.menu.clipboard_popup,  popup.getMenu());
                            popup.show();
                            popup.setOnMenuItemClickListener(new  PopupMenu.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem item) {

                                    switch (item.getItemId()) {
                                        case R.id.file_rename_menu:


                                            final String filename = folderList.get(position).getName();
                                            final String ext =   filename.substring(filename.indexOf(".") + 1);

                                            AlertDialog.Builder builderR = new AlertDialog.Builder(context);
                                            builderR.setTitle("Rename file");
                                            builderR.setCancelable(true);

                                            final EditText input = new EditText(context);
                                            input.setText(filename.substring(0, filename.indexOf(".")));
                                            builderR.setView(input);

                                            builderR.setPositiveButton("Rename", new DialogInterface.OnClickListener() {

                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if(input.getText().toString().equals("")){
                                                        UtilClass.getInstance().displayToast(context, "Please enter a name for the file", Toast.LENGTH_LONG);
                                                    }
                                                    else{
                                                        File from = new File(Environment.getExternalStorageDirectory() + "/Documents/Files/" + filename);

                                                        File to = new File(Environment.getExternalStorageDirectory() + "/Documents/Files/" + input.getText().toString() + "." + ext);

                                                        boolean renamed = from.renameTo(to);

                                                        if(renamed){
                                                            System.out.println("The position is " + position);
                                                            /** I have to do it here, don't I? How should I update the listview with the renamed file name?     **/
                                                            notifyDataSetChanged();
                                                        }
                                                    }
                                                }
                                            });

                                            builderR.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            });

                                            AlertDialog alertR = builderR.create();
                                            alertR.show();

                                            break;
                                    }
                                }
                            });
                    }
                }
            }

        }

            }
        });
        createAuthProgressDialog();


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
                } else {

                }
            }
        };
    }

    private void createAuthProgressDialog() {
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.setMessage("Saving...");
        mAuthProgressDialog.setCancelable(false);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main1, menu);
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
