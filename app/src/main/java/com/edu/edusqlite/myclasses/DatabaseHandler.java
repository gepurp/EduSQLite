package com.edu.edusqlite.myclasses;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notes_database";
    private static final int DATABASE_VERSION = 1;
    private static final String NOTES_TABLE = "notes_table";
    private static final String ID_KEY = "id";
    private static final String TITLE_KEY = "title";
    private static final String TEXT_KEY = "text";
    private static final String PURPOSE_KEY = "purpose";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDataBaseSQLCommand = "create table " + NOTES_TABLE +
                "( " + ID_KEY + " integer primary key autoincrement" +
                ", " + TITLE_KEY + " text" +
                ", " + TEXT_KEY + " text" +
                ", " + PURPOSE_KEY + " text" + " )";

        db.execSQL(createDataBaseSQLCommand);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + NOTES_TABLE);
        onCreate(db);
    }

    public void addNote(Note noteObject) {
        SQLiteDatabase database = getWritableDatabase();
        String addNoteSQLCommand = "insert into " + NOTES_TABLE +
                " values(null, '" + noteObject.getNoteTitle() +
                "', '" + noteObject.getNoteText() +
                "', '" + noteObject.getNotePurpose() + "')";
        database.execSQL(addNoteSQLCommand);
        database.close();
    }

    public void deleteNoteObjectByID(int id) {
        SQLiteDatabase database = getWritableDatabase();
        String deleteNoteSQLCommand = "delete from " + NOTES_TABLE +
                " where " + ID_KEY + " = " + id;
        database.execSQL(deleteNoteSQLCommand);
        database.close();
    }

    public void modifyNoteObject(int id, String title, String text, String purpose) {
        SQLiteDatabase database = getWritableDatabase();
        String modifyNoteSQLCommand = "update " + NOTES_TABLE +
                " set " + TITLE_KEY + " = '" + title +
                "', " + TEXT_KEY + " = '" + text +
                "', " + PURPOSE_KEY + " = '" + purpose +
                "' " + "where " + ID_KEY + " = " + id;
        database.execSQL(modifyNoteSQLCommand);
        database.close();
    }

    public ArrayList<Note> returnAllNotes() {
        SQLiteDatabase database = getWritableDatabase();
        String sqlQueryCommand = "select * from " + NOTES_TABLE;
        Cursor cursor = database.rawQuery(sqlQueryCommand, null);

        ArrayList<Note> notes = new ArrayList<>();

        while (cursor.moveToNext()) {
            Note currentNote = new Note(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3));
            notes.add(currentNote);
        }

        database.close();

        return notes;
    }


}
