package com.example.questionanddrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//TODO: Add a page for creating your own cards (to be saved on device)

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play, howto, settings;
        play = findViewById(R.id.playbtn);
        howto = findViewById(R.id.howbtn);
        settings = findViewById(R.id.settingsbtn);

        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                playGame();
            }
        });
    }

    public void playGame(){
        Intent intent = new Intent(this, addPlayers.class);
        startActivity(intent);
    }
}