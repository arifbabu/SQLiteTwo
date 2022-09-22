package com.example.sqlitetwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    private Button BangladeshButton, IndiaButton, PakistanButton, italyButton, japanButton, kingdomButton, usaButton;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BangladeshButton = findViewById(R.id.bangladeshId);
        IndiaButton = findViewById(R.id.indiaId);
        PakistanButton = findViewById(R.id.pakistanId);
        italyButton = findViewById(R.id.italyId);
        japanButton = findViewById(R.id.japanId);
        kingdomButton = findViewById(R.id.kingdomId);
        usaButton = findViewById(R.id.usaId);

        BangladeshButton.setOnClickListener(this);
        IndiaButton.setOnClickListener(this);
        PakistanButton.setOnClickListener(this);
        italyButton.setOnClickListener(this);
        japanButton.setOnClickListener(this);
        kingdomButton.setOnClickListener(this);
        usaButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.bangladeshId){
            intent = new Intent(MainActivity2.this, ProfileActivity.class);
            intent.putExtra("name", "bangladesh");
            startActivity(intent);
        }
        if(view.getId()==R.id.indiaId){
            intent = new Intent(MainActivity2.this, ProfileActivity.class);
            intent.putExtra("name", "india");
            startActivity(intent);
        }
        if(view.getId()==R.id.pakistanId){
            intent = new Intent(MainActivity2.this, ProfileActivity.class);
            intent.putExtra("name", "pakistan");
            startActivity(intent);
        }
        if(view.getId()==R.id.italyId){
            intent = new Intent(MainActivity2.this, ProfileActivity.class);
            intent.putExtra("name", "italy");
            startActivity(intent);
        }
        if(view.getId()==R.id.japanId){
            intent = new Intent(MainActivity2.this, ProfileActivity.class);
            intent.putExtra("name", "japan");
            startActivity(intent);
        }
        if(view.getId()==R.id.kingdomId){
            intent = new Intent(MainActivity2.this, ProfileActivity.class);
            intent.putExtra("name", "kingdom");
            startActivity(intent);
        }
        if(view.getId()==R.id.usaId){
            intent = new Intent(MainActivity2.this, ProfileActivity.class);
            intent.putExtra("name", "usa");
            startActivity(intent);
        }
    }
}