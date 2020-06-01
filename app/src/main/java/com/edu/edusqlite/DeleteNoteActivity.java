package com.edu.edusqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.edu.edusqlite.myclasses.DatabaseHandler;
import com.edu.edusqlite.myclasses.Note;

import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        databaseHandler = new DatabaseHandler(DeleteNoteActivity.this);

        updateUserInterface();

    }

    public void updateUserInterface() {
        ArrayList<Note> allNotes = databaseHandler.returnAllNotes();
        RelativeLayout relativeLayout = new RelativeLayout(DeleteNoteActivity.this);
        ScrollView scrollView = new ScrollView(DeleteNoteActivity.this);
        RadioGroup radioGroup = new RadioGroup(DeleteNoteActivity.this);

        for (Note note : allNotes) {

            RadioButton radioButton = new RadioButton(DeleteNoteActivity.this);
            radioButton.setId(note.getNoteID());
            radioButton.setText(note.getAllInfo());

            radioGroup.addView(radioButton);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                databaseHandler.deleteNoteObjectByID(checkedId);
                Toast.makeText(DeleteNoteActivity.this,
                        "Note was deleted",
                        Toast.LENGTH_LONG).show();
                updateUserInterface();
            }
        });

        scrollView.addView(radioGroup);

        ScrollView.LayoutParams scrollViewParam = new ScrollView.LayoutParams(
                        ScrollView.LayoutParams.MATCH_PARENT,
                        ScrollView.LayoutParams.MATCH_PARENT);

        relativeLayout.addView(scrollView);

        setContentView(relativeLayout);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
