package com.example.questionanddrink;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


//TODO: Add a way to delete a single player (used if name is incorrect)
//TODO: Add a way to set a host player (make it automatic for time being)

public class addPlayers extends AppCompatActivity {

    playerDB db;

    ArrayList<players> ListPlayers;
    players Players;
    ListView playerList;
    TextView emptyList;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        db = new playerDB(this); //Initialising DB

         //listing and declaring page contents
        Button btnAddName;
        Button btnExit;
        final EditText etName;

        etName = (EditText) findViewById(R.id.playerName);
        btnAddName = findViewById(R.id.savePlayerBtn);
        btnExit = findViewById(R.id.closebtn);

        //Setting up the lists for the players names
        playerList = (ListView) findViewById(R.id.playerList);

        emptyList = (TextView) findViewById(R.id.empty);

        btnAddName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                Integer points = 0;

                if(name != null){
                    db.addPlayers(name, points);
                    etName.setText("");
                    generatePlayerList();
                } else {
                    Toast.makeText(addPlayers.this, "No Name Inserted!", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitGame();
            }
        });
    }

    public void generatePlayerList(){
        ListPlayers = new ArrayList<>();
        final Cursor data = db.getDbData();
        final int playerNo = data.getCount();

        if (playerNo == 0){
            playerList.setVisibility(View.GONE); //should be invisible till data is inserted
            Toast.makeText(addPlayers.this, "Welcome To Conor's Drinking Game!!!", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()){
                Players = new players(data.getString(0), data.getString(1), data.getInt(2));
                ListPlayers.add(Players);
            }

            playersList adapter = new playersList(this, R.layout.add_player_list_item, ListPlayers);
            playerList = findViewById(R.id.playerList);
            playerList.setAdapter(adapter);
            playerList.setVisibility(View.VISIBLE);
            emptyList.setVisibility(View.GONE);
        }
    }

    public void exitGame(){
        //All tasks that need completing when exiting game
        db.deleteAll();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
