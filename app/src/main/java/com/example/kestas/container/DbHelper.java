package com.example.kestas.container;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Drager on 4/18/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String TAG = "DbHelper";

    public static final String TABLE_NAME = "Notes";
    public static final String TABLE_COL_ID = "ID";
    public static final String TABLE_COL_TITLE = "TITLE";
    public static final String TABLE_COL_NOTE = "NOTE";

    public DbHelper(Context context){
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE_COL_TITLE + " TEXT, " + TABLE_COL_NOTE + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    //Adding title/text to DB
    public boolean addData(String title,String note){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_COL_TITLE,title);
        contentValues.put(TABLE_COL_NOTE,note);

        Log.d(TAG,"addTitle: Adding " + title + " to " + TABLE_NAME);
        Log.d(TAG,"addText: Adding " + note + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null , contentValues);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }
    //Returns all data;
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

}















