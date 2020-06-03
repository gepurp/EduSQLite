package com.edu.edusqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.net.IpSecManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
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
            EditText[][] edtNoteProperties = new EditText[noteObjects.size()][3];

            // Set modify button for each note
            Button[] modifyButton = new Button[noteObjects.size()];

            Point screenSize = new Point();
            getWindowManager().getDefaultDisplay().getSize(screenSize);

            int screenWidth = screenSize.x;
            int index = 0;

            for(Note currentNoteObject : noteObjects) {

                idTextViews[index] = new TextView(UpdateNoteActivity.this);
                idTextViews[index].setGravity(Gravity.CENTER);
                idTextViews[index].setText(currentNoteObject.getNoteID());

                edtNoteProperties[index][0] = new EditText(UpdateNoteActivity.this);
                edtNoteProperties[index][1] = new EditText(UpdateNoteActivity.this);
                edtNoteProperties[index][2] = new EditText(UpdateNoteActivity.this);

                edtNoteProperties[index][0].setText(currentNoteObject.getNoteTitle());
                edtNoteProperties[index][1].setText(currentNoteObject.getNoteText());
                edtNoteProperties[index][2].setText(currentNoteObject.getNotePurpose());

                edtNoteProperties[index][0].setId(currentNoteObject.getNoteID() + 10);
                edtNoteProperties[index][1].setId(currentNoteObject.getNoteID() + 20);
                edtNoteProperties[index][2].setId(currentNoteObject.getNoteID() + 30);

                modifyButton[index] = new Button(UpdateNoteActivity.this);
                modifyButton[index].setText("Modify");
                modifyButton[index].setId(currentNoteObject.getNoteID());
                modifyButton[index].setOnClickListener(UpdateNoteActivity.this);

                gridLayout.addView(idTextViews[index],
                        screenWidth / 8,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtNoteProperties[index][0],
                        (int) (screenWidth * 0.28),
                        ViewGroup.LayoutParams.WRAP_CONTENT);



                index++;
            }

        }
    }

    @Override
    public void onClick(View v) {

    }
}
