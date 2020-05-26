package com.edu.edusqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.edusqlite.myclasses.Note;

public class AddNoteActivity extends AppCompatActivity {

    // UI components declaration
    private EditText edtNoteTitle;
    private EditText edtNoteText;
    private EditText edtNotePurpose;
    private Button btnAddNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        // Showing the message when starting activity
        Toast.makeText(AddNoteActivity.this,
                "This is Add Note activity",
                Toast.LENGTH_LONG).show();

        // UI components initialization
        edtNoteTitle = findViewById(R.id.edtNoteTitle);
        edtNoteText = findViewById(R.id.edtNoteText);
        edtNotePurpose = findViewById(R.id.edtNotePurpose);
        btnAddNote = findViewById(R.id.btnAddNote);

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNoteToDataBase();
            }
        });

    }

    private void addNoteToDataBase() {

        String noteTitleValue = edtNoteTitle.getText() + "";
        String noteTextValue = edtNoteText.getText() + "";
        String notePurposeValue = edtNotePurpose.getText() + "";

        try {
            Note noteObject = new Note(noteTitleValue, noteTextValue, notePurposeValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
