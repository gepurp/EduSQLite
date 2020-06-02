package com.edu.edusqlite.myclasses;

import androidx.annotation.NonNull;

public class Note {

    private int noteID;
    private String noteTitle;
    private String noteText;
    private String notePurpose;

    public Note(int noteID, String noteTitle, String noteText, String notePurpose) {

        setNoteID(noteID);
        setNoteTitle(noteTitle);
        setNoteText(noteText);
        setNotePurpose(notePurpose);

    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getNotePurpose() {
        return notePurpose;
    }

    public void setNotePurpose(String notePurpose) {
        this.notePurpose = notePurpose;
    }

    public String getAllInfo() {
        return getNoteID() + " | " +
                getNoteTitle() + " | " +
                getNoteText() + " | " +
                getNotePurpose();
    }
}
