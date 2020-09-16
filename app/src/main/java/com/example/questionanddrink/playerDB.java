package com.example.questionanddrink;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class playerDB extends SQLiteOpenHelper {

    //Creating DB
    public static final String DB_NAME = "players.db";
    public static final String TABLE_NAME = "players";

    //Setting up DB
    public static final String COL1 = "ID";
    public static final String COL2 = "Name";
    public static final String COL3 = "Points";

    public playerDB(@Nullable Context context) {
        //Adding the DB context
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Setting up the db table for the players
        String createTable = "CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " Name TEXT, Points INTEGER)";
        //executing the tables creation
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //addPlayers method
    public boolean addPlayers(String name, Integer points){
        //Adding data that user has inputted
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2, name);
        cv.put(COL3, points);

        //making sure it is inserted correctly
        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    //method to retrieve content ready for display
    public Cursor getDbData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public void deletePlayer(String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE ID = " + ID;
        db.execSQL(query);
    }
    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME;
        db.execSQL(query);
    }
}
