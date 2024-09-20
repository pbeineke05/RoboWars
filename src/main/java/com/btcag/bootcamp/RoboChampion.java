package com.btcag.bootcamp;

public class RoboChampion {
    private int posX, posY, roboID, rot = 0;//rot = 0 : oben, rot = 1 : rechts, rot = 2 : unten, rot = 3 : links
    private char character;
    private String name;
    private boolean alive = true;

    public RoboChampion(char character, String name, int id) {
        this.character = character;
        this.name = name;
        this.roboID = id;
    }

    public char getChar() {
        return character;
    }

    public String getName() {
        return name;
    }

    public int getPositionX() {
        return posX;
    }

    public int getPositionY() {
        return posY;
    }

    public void setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getRotation() {
        return rot;
    }

    public void setRotation(int input) {
        if (rot < 4 && rot > -1) this.rot = input;
    }

    public int getRoboID() {
        return roboID;
    }

    public boolean getAliveStatus() {
        return alive;
    }

    public void setAliveStatus(boolean input) {
        this.alive = input;
    }
}
