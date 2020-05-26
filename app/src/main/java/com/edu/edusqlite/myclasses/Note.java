package com.edu.edusqlite.myclasses;

import androidx.annotation.NonNull;

public class Note {

    //private static int ID = 0;
    private String noteTitle;
    private String noteText;
    private String notePurpose;

    public Note(String noteTitle, String noteText, String notePurpose) {

        setNoteTitle(noteTitle);
        setNoteText(noteText);
        setNotePurpose(notePurpose);
        //ID++;
    }

    /*
    public static int getId() {
        return ID;
    }

    public static void setId(int id) {
        Note.id = ID;
    }
    */

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
}
