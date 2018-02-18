package com.rasco.myapp.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rasco.myapp.myapplication.base.Colors;

import java.util.ArrayList;

/**
 * Created by Admin on 2/15/2018.
 */

public class ColorsDB extends DBHandler {

    public static final String TABLE_COLORS = "COLORS";
    public static final String COLUMN_COLORS_ID = "colors_id";
    public static final String COLUMN_COLORS_NAME ="name";
    public static final String COLUMN_COLOR_ONE = "color_one";
    public static final String COLUMN_COLOR_TWO = "color_two";
    public static final String COLUMN_COLOR_THREE = "color_three";
    final static String CREATE_TABLE_COLORS = "CREATE TABLE " + TABLE_COLORS + "(" +
            COLUMN_COLORS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_COLORS_NAME + " TEXT, " +
            COLUMN_COLOR_ONE + " TEXT, " +
            COLUMN_COLOR_TWO + " TEXT, " +
            COLUMN_COLOR_THREE + " TEXT) ";

    public ColorsDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public Colors getColors(int colorsId) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_COLORS + " WHERE " +
                COLUMN_COLORS_ID + " = " + colorsId;

        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();
        Colors colors= new Colors(c.getInt(c.getColumnIndex(COLUMN_COLORS_ID)),
                c.getString(c.getColumnIndex(COLUMN_COLORS_NAME)),
                c.getString(c.getColumnIndex(COLUMN_COLOR_ONE)),
                c.getString(c.getColumnIndex(COLUMN_COLOR_TWO)),
                c.getString(c.getColumnIndex(COLUMN_COLOR_THREE)));

        return colors;
    }

    //Add a new row to the database
    public void addColors(Colors colors){
        ContentValues values = new ContentValues();
        values.put(COLUMN_COLORS_NAME, colors.getName());
        values.put(COLUMN_COLOR_ONE, colors.getColorOne());
        values.put(COLUMN_COLOR_TWO, colors.getColorTwo());
        values.put(COLUMN_COLOR_THREE, colors.getColorThree());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_COLORS, null, values);
        db.close();
    }

    public boolean updateColors(Colors colors) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_COLORS_NAME, colors.getName());
        contentValues.put(COLUMN_COLOR_ONE, colors.getColorOne());
        contentValues.put(COLUMN_COLOR_TWO, colors.getColorTwo());
        contentValues.put(COLUMN_COLOR_THREE, colors.getColorThree());

        db.update(TABLE_COLORS, contentValues, COLUMN_COLORS_ID + " = ? ",
                new String[]{Integer.toString(colors.get_id())});
        return true;
    }

    public void deleteColors(Colors colors) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM " + TABLE_COLORS + " WHERE " +
                COLUMN_COLORS_ID + " = ?" ;

        db.execSQL(query, new Integer[] {colors.get_id()});
        db.close();
    }

    public ArrayList<Colors> getAllColors(){
        ArrayList<Colors> colorsList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_COLORS + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex(COLUMN_COLORS_NAME)) != null) {
                colorsList.add(new Colors(c.getInt(c.getColumnIndex(COLUMN_COLORS_ID)),
                        c.getString(c.getColumnIndex(COLUMN_COLORS_NAME)),
                        c.getString(c.getColumnIndex(COLUMN_COLOR_ONE)),
                        c.getString(c.getColumnIndex(COLUMN_COLOR_TWO)),
                        c.getString(c.getColumnIndex(COLUMN_COLOR_THREE))));
            }
            c.moveToNext();
        }
        db.close();

        return colorsList;
    }
}