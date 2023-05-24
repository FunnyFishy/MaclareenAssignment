package com.example.maclareenassignment.Note;

public class NoteModel {


    private int id;
    private String title, description,created_at;


//    public NoteModel(String title, String description, String created_at) {
//        this.title = title;
//        this.description = description;
//        this.created_at = created_at;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
