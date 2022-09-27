package com.rajasekhar.app.todo;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Todo {

    private int id;
    private String username;

    @Size(min = 10, message = "Description too short!")
    private String description;
    private LocalDate date;
    private boolean isDone;


    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", isDone=" + isDone +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Todo(int id, String username, String description, LocalDate date, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.date = date;
        this.isDone = isDone;
    }


}
