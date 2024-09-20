package com.btcag.bootcamp;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Gson gson = new Gson();
    static HashMap<String, String> data = new HashMap<>();
    static File saveFile = new File("./src/save.txt");
    static String userName, playerRobotName;
    static char playerRobot;
    static Scanner cmdScanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        Board mainBoard = new Board(15, 10);
        gameStart();
        annoyUser(6000);
        mainBoard.printBoard();
        mainBoard.spawnRobot(selectRobot(), 14, 8);
        mainBoard.printBoard();
        new GameLoop(mainBoard);
    }

    private static RoboChampion selectRobot() {
        System.out.println();
        System.out.println("Wähle deinen RoboChampion!");
        if (data.containsKey("preset1") && data.containsKey("preset2") && data.containsKey("preset3")) {
            System.out.println("[1] " + data.get("preset1"));
            System.out.println("[2] " + data.get("preset2"));
            System.out.println("[3] " + data.get("preset3"));
            System.out.println("Oder wähle einen Custom Robot:");

            playerRobot = cmdScanner.nextLine().charAt(0);

            if (playerRobot == '1') playerRobot = data.get("preset1").charAt(0);
            if (playerRobot == '2') playerRobot = data.get("preset2").charAt(0);
            if (playerRobot == '3') playerRobot = data.get("preset3").charAt(0);
        }

        System.out.println("Wie soll dein RoboChampion heißen?");
        playerRobotName = cmdScanner.nextLine();

        return new RoboChampion(playerRobot, playerRobotName, 0);
    }

    private static void gameStart() throws IOException {
        readFile();
        if (data.containsKey("user")) {
            userName = data.get("user");
        } else {
            System.out.println("Bitte gib deinen Nutzernamen ein. Dieser kann nicht mehr angepasst werden!");
            userName = cmdScanner.nextLine();
            writeFile("user", userName);
            readFile();
        }
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║               RoboWars              ║");
        System.out.println("║                                     ║");
        System.out.println("║         Herzlich Willkommen         ║");

        System.out.print("║");
        for (int i = 0; i < (37 - userName.length()) / 2; i++) {
            System.out.print(" ");
        }
        System.out.print(userName);
        for (int i = 0; i < (37 - userName.length()) / 2; i++) {
            System.out.print(" ");
        }
        if (userName.length() % 2 == 0) System.out.print(" ");
        System.out.println("║");

        System.out.println("║       Viel Spaß beim Spielen!       ║");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("╚═════════════════════════════════════╝");
    }

    private static void readFile() throws IOException {
        FileReader saveReader = new FileReader(saveFile);
        StringBuilder savedData = new StringBuilder();

        System.out.print("Log: ");

        int i;
        while ((i = saveReader.read()) != -1) {
            System.out.print((char) i);
            savedData.append((char) i);
        }
        savedData.toString();
        data = gson.fromJson(savedData.toString(), HashMap.class);
        saveReader.close();

        System.out.println();
    }

    private static void writeFile(String key, String value) throws IOException {
        SaveWriter saveWriter = new SaveWriter(saveFile, false);

        System.out.println();
        data.put(key, value);
        saveWriter.write(gson.toJson(data));
        saveWriter.close();
    }

    private static void annoyUser(int milliseconds) throws InterruptedException {
        int minSteps = 4, maxSteps = 10;
        long loadingSteps = minSteps + (long) (Math.random() * ((maxSteps - minSteps) + 1));
        long waitingTime = milliseconds / loadingSteps, slashes = 20 / loadingSteps, percent = 0L;

        for (int i = 0; i < loadingSteps; i++) {
            System.out.println();
            System.out.print("Loading: |");
            for (int j = 0; j < slashes * (i + 1); j++) {
                System.out.print("/");
            }
            for (int j = 0; j < 20 - slashes * (i + 1); j++) {
                System.out.print(" ");
            }
            System.out.print("|");
            percent = 100 / loadingSteps * (i + 1);
            System.out.print(percent);
            System.out.print("%");
            Thread.sleep(waitingTime);
        }

        if (percent != 100) {
            System.out.println();
            System.out.println("Loading: |///////////////////|100%");
            Thread.sleep(waitingTime);
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }
}