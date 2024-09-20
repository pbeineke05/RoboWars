package com.btcag.bootcamp;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
    private int sizeX, sizeY;
    private Object[][] internalBoard;
    private HashMap<Integer, RoboChampion> activeRobots = new HashMap<>();

    public Board(int sizeXInput, int sizeYInput) {
        this.sizeX = sizeXInput + 2; //+2 due to wall on each side
        this.sizeY = sizeYInput + 2;
        internalBoard = new Object[sizeX][sizeY];
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (i == 0 || j == 0 || i == sizeY - 1 || j == sizeX - 1) {
                    internalBoard[j][i] = '/';
                } else {
                    internalBoard[j][i] = '_';
                }
            }
        }
    }

    public void spawnRobot(RoboChampion robot, int spawnX, int spawnY) {
        if (internalBoard[spawnX][spawnY].equals('_')) {
            internalBoard[spawnX][spawnY] = robot;
            robot.setPosition(spawnX, spawnY);
            activeRobots.put(robot.getRoboID(), robot);
        } else {
            throw new Error("Der genannte SpawnPoint ist nicht leer. Spawn nicht möglich");
        }
    }

    public HashMap<Integer, RoboChampion> getActiveRobots() {
        return activeRobots;
    }

    public void loadMap(String filePath) {

    }

    public void printBoard() {
        for (int i = 0; i < sizeY; i++) {
            System.out.println();
            for (int j = 0; j < sizeX; j++) {
                if (internalBoard[j][i].getClass() == RoboChampion.class) {
                    RoboChampion temp = (RoboChampion) internalBoard[j][i];
                    switch (temp.getRotation()) {
                        case 0: //oben
                            System.out.print('˄');
                            System.out.print(temp.getChar() + " ");
                            break;
                        case 1: //rechts
                            System.out.print(" " + temp.getChar());
                            System.out.print('.');
                            break;
                        case 2: //unten
                            System.out.print(" " + temp.getChar());
                            System.out.print('˅');
                            break;
                        case 3: //links
                            System.out.print('.');
                            System.out.print(temp.getChar() + " ");
                            break;
                    }

                } else {
                    System.out.print(" " + internalBoard[j][i] + " ");
                }
            }
        }
        System.out.println();
    }

    public boolean moveRoboUp(int id) {
        int prevPosX,
                prevPosY;
        prevPosX = activeRobots.get(id).getPositionX();
        prevPosY = activeRobots.get(id).getPositionY();

        if (internalBoard[prevPosX][prevPosY - 1].equals('_')) { //Zug valide, da Feld frei
            internalBoard[prevPosX][prevPosY] = '_';
            internalBoard[prevPosX][prevPosY - 1] = activeRobots.get(id);
            activeRobots.get(id).setPosition(prevPosX, prevPosY - 1);
            return true;
        }
        return false;
    }

    public boolean moveRoboRight(int id) {
        int prevPosX,
                prevPosY;
        prevPosX = activeRobots.get(id).getPositionX();
        prevPosY = activeRobots.get(id).getPositionY();

        if (internalBoard[prevPosX + 1][prevPosY].equals('_')) { //Zug valide, da Feld frei
            internalBoard[prevPosX][prevPosY] = '_';
            internalBoard[prevPosX + 1][prevPosY] = activeRobots.get(id);
            activeRobots.get(id).setPosition(prevPosX + 1, prevPosY);
            return true;
        }
        return false;
    }

    public boolean moveRoboDown(int id) {
        int prevPosX, prevPosY;
        prevPosX = activeRobots.get(id).getPositionX();
        prevPosY = activeRobots.get(id).getPositionY();

        if (internalBoard[prevPosX][prevPosY + 1].equals('_')) { //Zug valide, da Feld frei
            internalBoard[prevPosX][prevPosY] = '_';
            internalBoard[prevPosX][prevPosY + 1] = activeRobots.get(id);
            activeRobots.get(id).setPosition(prevPosX, prevPosY + 1);
            return true;
        }
        return false;
    }

    public boolean moveRoboLeft(int id) {
        int prevPosX, prevPosY;
        prevPosX = activeRobots.get(id).getPositionX();
        prevPosY = activeRobots.get(id).getPositionY();

        if (internalBoard[prevPosX - 1][prevPosY].equals('_')) { //Zug valide, da Feld frei
            internalBoard[prevPosX][prevPosY] = '_';
            internalBoard[prevPosX - 1][prevPosY] = activeRobots.get(id);
            activeRobots.get(id).setPosition(prevPosX - 1, prevPosY);
            return true;
        }
        return false;
    }

    public void turnRoboLeft(int id) {
        int rot = activeRobots.get(id).getRotation();
        rot = rot - 1 < 0 ? rot + 3 : rot - 1;
        activeRobots.get(id).setRotation(rot);
    }

    public void turnRoboRight(int id) {
        int rot = activeRobots.get(id).getRotation();
        rot = rot + 1 > 3 ? rot - 3 : rot + 1;
        activeRobots.get(id).setRotation(rot);
    }

    public void roboAction1(int id) {
        int posX = activeRobots.get(id).getPositionX(),
                posY = activeRobots.get(id).getPositionY();

        switch (activeRobots.get(id).getRotation()) {
            case 0:
                doDamage(posX, posY, 0, -1, id);
                break;
            case 1:
                doDamage(posX, posY, +1, 0, id);
                break;
            case 2:
                doDamage(posX, posY, 0, +1, id);
                break;
            case 3:
                doDamage(posX, posY, -1, 0, id);
                break;
        }
    }

    public void roboAction2(int id) {
        int posX = activeRobots.get(id).getPositionX(),
                posY = activeRobots.get(id).getPositionY();

        switch (activeRobots.get(id).getRotation()) {
            case 0:
                doDamage(posX, posY, +1, -1, id);
                break;
            case 1:
                doDamage(posX, posY, +1, +1, id);
                break;
            case 2:
                doDamage(posX, posY, -1, +1, id);
                break;
            case 3:
                doDamage(posX, posY, -1, -1, id);
                break;
        }
    }

    private void doDamage(int posX, int posY, int offsetX, int offsetY, int damageDealerID) {
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (internalBoard[posX + offsetX][posY + offsetY].equals('_')) { //Free spot
            this.printBoard();
            internalBoard[posX + offsetX][posY + offsetY] = '*';
            doDamage(posX + offsetX, posY + offsetY, offsetX, offsetY, damageDealerID);
            internalBoard[posX + offsetX][posY + offsetY] = '_';
        } else if (internalBoard[posX + offsetX][posY + offsetY].equals('/')) { //Hit Wall
            this.printBoard();
            System.out.println("Kein Gegner getroffen");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            RoboChampion hitRobot = (RoboChampion) internalBoard[posX + offsetX][posY + offsetY];
            hitRobot.setAliveStatus(false);
            killAnimation(activeRobots.get(damageDealerID), hitRobot);
        }
    }

    private void killAnimation(RoboChampion winner, RoboChampion killed) {

    }
}
