package com.example.kestas.container;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import static com.example.kestas.container.DbHelper.TABLE_COL_NOTE;
import static com.example.kestas.container.DbHelper.TABLE_COL_TITLE;

/**
 * Created by Drager on 4/19/2017.
 */

public class TodoCursorAdapter extends CursorAdapter {
    public TodoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView ViewTitle = (TextView) view.findViewById(R.id.ViewTitle);
        TextView ViewNote = (TextView) view.findViewById(R.id.ViewNote);
        // Extract properties from cursor
        String title = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_COL_TITLE));
        String note = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_COL_NOTE));
        // Populate fields with extracted properties
        ViewTitle.setText(title);
        ViewNote.setText(note);
    }
}
