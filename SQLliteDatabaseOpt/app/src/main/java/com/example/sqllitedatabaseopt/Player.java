package com.example.sqllitedatabaseopt;

public class Player {
    private int id;
    private String name;
    private String position;
    private int height;

    public Player() {
    }

    public Player(String name, String position, int height) {
        this.name = name;
        this.position = position;
        this.height = height;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString(){
        return name + "-" + position + "-" +height;
    }
}
