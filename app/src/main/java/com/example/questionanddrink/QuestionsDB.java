package com.example.questionanddrink;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//TODO: Create a question class that will hold the components of a question
//TODO: Make a list function that will make sense of the questions within the DB

public class QuestionsDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "questions.db";
    public static final String TABLE_NAME = "questions";

    public static final String COL1 = "ID";
    public static final String COL2 = "Question";
    public static final String COL3 = "Answer";
    public static final String COL4 = "Asked";

    public QuestionsDB(@Nullable Context context) {
        //Context for DB
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " Name TEXT, Points INTEGER)";
        //Creating table
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void populateQuiz(){

    }
    public void addQuestions(){
        ContentValues cv = new ContentValues();
    }
}
