package com.btcag.bootcamp;

import java.util.ArrayList;

public class Board {
    private int sizeX, sizeY;
    private char[][] internalBoard;
    private ArrayList<RoboChampion> activeRobots = new ArrayList<>();

    public Board(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        internalBoard = new char[sizeX][sizeY];
        for (int i = 0; i < sizeY; i++){
            System.out.println();
            for (int j = 0; j < sizeX; j++){
                if(i == 0 || j == 0 || i == sizeY - 1 || j == sizeX - 1){
                    internalBoard[j][i] = '/';
                } else {
                    internalBoard[j][i] = '_';
                }
                System.out.print("  ");
            }
        }
    }

    public void spawnRobot(RoboChampion robot, int spawnX, int spawnY){
        if(internalBoard[spawnX][spawnY] == '_'){
            internalBoard[spawnX][spawnY] = robot.getChar();
            robot.setPosition(spawnX, spawnY);
            activeRobots.add(robot);
        } else {
            throw new Error("Der genannte SpawnPoint ist nicht leer. Spawn nicht möglich");
        }
    }

    public void loadMap(String filePath){

    }

    public void printBoard(){
        for (int i = 0; i < sizeY; i++) {
            System.out.println();
            for (int j = 0; j < sizeX; j++) {
                System.out.print(internalBoard[j][i] + "  ");
            }
        }
    }
}
