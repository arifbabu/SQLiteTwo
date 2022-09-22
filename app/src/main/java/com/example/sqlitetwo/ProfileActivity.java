package com.example.sqlitetwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView = findViewById(R.id.imageViewId);
        textView = findViewById(R.id.textViewId);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String countryName = bundle.getString("name");
            showDetails(countryName);
        }
    }

    void showDetails(String countryName){
        if(countryName.equals("bangladesh")){
            //canada
            imageView.setImageResource(R.drawable.canada);
            textView.setText(R.string.bangladesh_text);
        }
        if(countryName.equals("india")){
            // france
            imageView.setImageResource(R.drawable.france);
            textView.setText(R.string.india_text);
        }
        if(countryName.equals("pakistan")){
            // germany
            imageView.setImageResource(R.drawable.germany);
            textView.setText(R.string.pakistan_text);
        }
        if(countryName.equals("italy")){
            imageView.setImageResource(R.drawable.italy);
            textView.setText(R.string.italy_text);
        }
        if(countryName.equals("japan")){
            imageView.setImageResource(R.drawable.japan);
            textView.setText(R.string.japan_text);
        }
        if(countryName.equals("kingdom")){
            imageView.setImageResource(R.drawable.france);
            textView.setText(R.string.kingdom_text);
        }
        if(countryName.equals("usa")){
            imageView.setImageResource(R.drawable.canada);
            textView.setText(R.string.usa_text);
        }
    }
}