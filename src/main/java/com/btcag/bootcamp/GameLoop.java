package com.btcag.bootcamp;

import java.util.Scanner;

public class GameLoop {
    Scanner playerInput = new Scanner(System.in);

    public GameLoop(Board playingBoard) {
        while (playingBoard.getActiveRobots().get(0).getAliveStatus()) {
            System.out.println("Gib deinen Move ein:");
            System.out.println("[W] - Schritt hoch");
            System.out.println("[A] - Schritt nach links");
            System.out.println("[S] - Schritt runter");
            System.out.println("[D] - Schritt nach rechts");
            System.out.println("[<] - Nach links drehen"); //links: Punkt links von Robo, rechts: Punkt rechts von Robo
            System.out.println("[>] - Nach rechts drehen"); //oben: ˄ links von Robo, unten: ˅ rechts von Robo
            System.out.println("[1] - Angriff in Sichtrichtung gerade");
            System.out.println("[2] - Angriff rechts von Sichtrichtung quer");

            String currentInput = playerInput.nextLine();

            if (currentInput.equals("break")) break;

            currentInput = (currentInput.charAt(0) + "").toUpperCase();

            switch (currentInput) {
                case "W":
                    if (!playingBoard.moveRoboUp(0))
                        System.out.println("Dein Zug ist invalide. Probiere eine andere Eingabe.");
                    else System.out.println("Zug ausgeführt");
                    break;
                case "A":
                    if (!playingBoard.moveRoboLeft(0))
                        System.out.println("Dein Zug ist invalide. Probiere eine andere Eingabe.");
                    else System.out.println("Zug ausgeführt");
                    break;
                case "S":
                    if (!playingBoard.moveRoboDown(0))
                        System.out.println("Dein Zug ist invalide. Probiere eine andere Eingabe.");
                    else System.out.println("Zug ausgeführt");
                    break;
                case "D":
                    if (!playingBoard.moveRoboRight(0))
                        System.out.println("Dein Zug ist invalide. Probiere eine andere Eingabe.");
                    else System.out.println("Zug ausgeführt");
                    break;
                case "<":
                    playingBoard.turnRoboLeft(0);
                    System.out.println("Zug ausgeführt");
                    break;
                case ">":
                    playingBoard.turnRoboRight(0);
                    System.out.println("Zug ausgeführt");
                    break;
                case "1":
                    playingBoard.roboAction1(0);
                    System.out.println("Zug ausgeführt");
                    break;
                case "2":
                    playingBoard.roboAction2(0);
                    System.out.println("Zug ausgeführt");
                    break;
                default:
                    System.out.println("Dies ist keine Option. Probiere eine andere Eingabe.");
            }

            playingBoard.printBoard();
        }
    }
}
