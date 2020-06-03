package com.edu.edusqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.net.IpSecManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.GridLayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.edu.edusqlite.myclasses.DatabaseHandler;
import com.edu.edusqlite.myclasses.Note;

import java.util.ArrayList;

public class UpdateNoteActivity extends AppCompatActivity implements View.OnClickListener {

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

            ScrollView scrollView = new ScrollView(UpdateNoteActivity.this);

            // Create grid layout for place all note objects
            // Set row count with respect of notes count
            // Set column for id, title, text, purpose and button which allow to edit note
            GridLayout gridLayout = new GridLayout(UpdateNoteActivity.this);
            gridLayout.setRowCount(noteObjects.size());
            gridLayout.setColumnCount(5);

            TextView[] idTextViews = new TextView[noteObjects.size()];

            // Set edit text for title, text and purpose of note
            EditText[][] edtNoteObjects = new EditText[noteObjects.size()][3];

            // Set modify button for each note
            Button[] modifyButton = new Button[noteObjects.size()];


        }
    }

    @Override
    public void onClick(View v) {

    }
}
