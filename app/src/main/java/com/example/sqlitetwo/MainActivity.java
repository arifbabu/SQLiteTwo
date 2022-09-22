package com.example.sqlitetwo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText, ageEditText, genderEditText, idEditText;
    private Button addButton ;
    private Button showinfo ;
    private Button displayAllDataButton;
    private Button updateButton;
    private Button deleteButton;
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        idEditText = findViewById(R.id.idEditTextId);
        nameEditText = findViewById(R.id.nameEditTextId);
        ageEditText = findViewById(R.id.ageEditTextId);
        genderEditText = findViewById(R.id.genderEditTextId);
        addButton = findViewById(R.id.addButtonId);
        displayAllDataButton = findViewById(R.id.displayAllDataButtonId);
        updateButton = findViewById(R.id.updateDataButtonId);
        deleteButton = findViewById(R.id.deleteDataButtonId);
        showinfo = findViewById(R.id.showInfoButtonId);

        addButton.setOnClickListener(this);
        displayAllDataButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        showinfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String id = idEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();

        if(view.getId()==R.id.addButtonId)
        {
           long rowId =  myDatabaseHelper.inserData(name, age, gender);

            if(rowId== -1)
            {
                Toast.makeText(getApplicationContext(), " Unsuccessful ", Toast.LENGTH_LONG).show();
            }else
           {
               Toast.makeText(getApplicationContext(), " Row "+rowId+" is Successfully inserted ", Toast.LENGTH_LONG).show();
           }
        }

        if(view.getId()==R.id.displayAllDataButtonId)
        {
           Cursor cursor = myDatabaseHelper.displayAllData();
           if(cursor.getCount()==0)
           {
               // there is no data so we will display message
               showData("Error", "No data Found");
               return;
           }
           StringBuffer stringBuffer = new StringBuffer();
           while (cursor.moveToNext())
           {
               stringBuffer.append("ID : " + cursor.getString(0)+ "\n");
               stringBuffer.append("Name : " + cursor.getString(1)+ "\n");
               stringBuffer.append("Age : " + cursor.getString(2)+ "\n");
               stringBuffer.append("Gender : " + cursor.getString(3)+ "\n\n\n");
           }
           showData("ResultSet", stringBuffer.toString());
        }
        else if(view.getId()==R.id.updateDataButtonId)
        {
          Boolean isUpdated =  myDatabaseHelper.updateDate(id, name, age, gender);
          if(isUpdated ==true)
          {
              Toast.makeText(getApplicationContext(), " Data is Updated ", Toast.LENGTH_SHORT).show();
          }else
          {
              Toast.makeText(getApplicationContext(), " Not Updated ", Toast.LENGTH_SHORT).show();
          }
        }

        if(view.getId()==R.id.deleteDataButtonId)
        {
           int value = myDatabaseHelper.deleteData(id);
           if(value > 0)
           {
               Toast.makeText(getApplicationContext(), " Data is Deleted  ", Toast.LENGTH_SHORT).show();
           }else
               {
                   Toast.makeText(getApplicationContext(), " Not Deleted ", Toast.LENGTH_SHORT).show();
               }
        }
        if(view.getId()==R.id.showInfoButtonId)
        {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }

    }

    public void showData(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }
}