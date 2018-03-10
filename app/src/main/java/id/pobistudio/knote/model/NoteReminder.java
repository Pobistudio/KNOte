package id.pobistudio.knote.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by kukuh on 24/02/18.
 */

public class NoteReminder extends RealmObject {

    @PrimaryKey
    private int id;
    private String noteId;
    private Date reminderDate;

    public NoteReminder() {
    }

    public NoteReminder(int id, String noteId, Date reminderDate) {
        this.id = id;
        this.noteId = noteId;
        this.reminderDate = reminderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }
}
