package com.example.kestas.container;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    DbHelper mDbHelper;
    public Button btnAdd,btnViewData;
    public EditText editTitle;
    public EditText editNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTitle = (EditText) findViewById(R.id.editTitle);
        editNote = (EditText) findViewById(R.id.editNote);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnViewData = (Button) findViewById(R.id.btnView);
        mDbHelper = new DbHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String newTitle = editTitle.getText().toString();
                String newNote = editNote.getText().toString();
                if(editTitle.length() != 0 && editNote.length() != 0){
                    AddData(newTitle,newNote);
                    editTitle.setText("");
                    editNote.setText("");
                } else {
                    toastMessage("Input wrong");
                }
            }
        });
        btnViewData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
                startActivity(intent);
            }
        });
    }
    public void AddData(String newTitle, String newNote){
        boolean insertData = mDbHelper.addData(newTitle,newNote);
        if(insertData){
            toastMessage("Note created succesfully!");
        } else {
            toastMessage("Something went wrong!");
        }

    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }



}