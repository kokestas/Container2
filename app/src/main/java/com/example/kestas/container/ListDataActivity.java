package com.example.kestas.container;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;


import static com.example.kestas.container.DbHelper.TABLE_COL_NOTE;
import static com.example.kestas.container.DbHelper.TABLE_COL_TITLE;
import static com.example.kestas.container.R.id.listView;
import static com.example.kestas.container.R.id.noteView;


/**
 * Created by Drager on 4/19/2017.
 */

public class ListDataActivity extends AppCompatActivity {
    private static final String TAG = "ListDataActivity";
    DbHelper mDbHelper;
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = (ListView) findViewById(listView);

        mDbHelper = new DbHelper(this);
        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");


        //Get the data and add to ListView
        Cursor cursor = mDbHelper.getData();
        TodoCursorAdapter todoAdapter = new TodoCursorAdapter(this,cursor);

        mListView.setAdapter(todoAdapter);
    }
}
