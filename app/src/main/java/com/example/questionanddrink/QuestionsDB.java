package com.example.questionanddrink;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//TODO: Make a list function that will make sense of the questions within the DB
//TODO: Make a function that will store the answered and unanswered questions

public class QuestionsDB extends SQLiteOpenHelper {

    private SQLiteDatabase db;

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
        populateQuiz();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void populateQuiz(){
        Question q1 = new Question("What is the capital of England?", "London", false);#
        addQuestion(q1);
        Question q2 = new Question("What's Conor's middle name?", "Patrick", false);
        addQuestion(q2);
        Question q3 = new Question("What's the disease taking over 2020?", "Covid", false);
        addQuestion(q3);
    }

    public void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(COL2, question.getQuestion());
        cv.put(COL3, question.getAnswer());
        cv.put(COL4, question.getAsked());
        db.insert(TABLE_NAME, null, cv);
    }

    public void unaskedQuestions(){
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL4 + " = FALSE", null);
    }

}
