package com.example.tic_tac_toe_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void twoplayer(View v){

        Intent i = new Intent(this,twoplayer_Activity.class);
        startActivity(i);
    }
    public void computer(View v){

        Intent i = new Intent(this,Computer.class);
        startActivity(i);
    }

    public void settings(View v){

        Intent i = new Intent(this,Settings_Activity.class);
        startActivity(i);
    }
}