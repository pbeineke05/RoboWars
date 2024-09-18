package com.btcag.bootcamp;

public class RoboChampion {
    private int posX, posY;
    private char character;
    private String name;

    public RoboChampion(char character, String name){
        this.character = character;
        this.name = name;
    }

    public char getChar() {
        return character;
    }

    public String getName() {
        return name;
    }

    public int getPositionX(){
        return posX;
    }

    public int getPositionY(){
        return posY;
    }

    public void setPosition(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
}
