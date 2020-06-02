package com.edu.edusqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.edu.edusqlite.myclasses.DatabaseHandler;
import com.edu.edusqlite.myclasses.Note;

import java.util.ArrayList;

public class UpdateNoteActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);

        databaseHandler = new DatabaseHandler (UpdateNoteActivity.this);

        updateUserInterface();
    }

    public void updateUserInterface() {
        ArrayList<Note> noteObjects = databaseHandler.returnAllNotes();

        if (noteObjects.size() > 0) {

        }
    }
}
