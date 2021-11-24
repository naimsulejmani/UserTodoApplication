package ict.kosovo.growth.usertodoapplication.models;

import javafx.scene.paint.Color;

import java.time.LocalDate;

public class TodoItem {
    private int id;
    private String name;
    private String description;
    private LocalDate deadline;
    private boolean isFinished;
    private Color color;

    public TodoItem(int id, String name, String description, LocalDate deadline, boolean isFinished, Color color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.isFinished = isFinished;
        this.color = color;
    }

    public TodoItem(String name, String description, LocalDate deadline, boolean isFinished, Color color) {
        this(0,name,description,deadline,isFinished,color);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
