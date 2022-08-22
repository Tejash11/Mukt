package com.example.mukt;

public class Task {

    String name;
    int id;
    int total;
    int completed;

    public Task(String name, int id, int total, int completed) {
        this.name = name;
        this.id = id;
        this.total = total;
        this.completed = completed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }

    public int getCompleted() {
        return completed;
    }
}
