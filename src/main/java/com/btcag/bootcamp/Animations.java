package com.btcag.bootcamp;

public class Animations {
    static int sleepTime = 150;

    public static void killAnimation(RoboChampion winnerRobo, RoboChampion killedRobo) {
        char winner = winnerRobo.getChar(), killed = killedRobo.getChar();
        topHalf();
        System.out.print(winner + "                 " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "-                " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "--               " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "---              " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "----             " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "-----            " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + " -----           " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "  -----          " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "   -----         " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "    -----        " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "     -----       " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "      -----      " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "       -----     " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "        -----    " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "         -----   " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "          -----  " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "           ----- " + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "            -----" + killed);
        bottomHalf();

        nextFrame();

        topHalf();
        System.out.print(winner + "             ----*");
        bottomHalf();

        nextFrame();

        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("║                          * *        ║");
        System.out.println("║         " + winner + "              ---*         ║");
        System.out.println("║                          * *        ║");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("╚═════════════════════════════════════╝");

        nextFrame();

        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║                         *   *       ║");
        System.out.println("║                          * *        ║");
        System.out.println("║         " + winner + "               --*         ║");
        System.out.println("║                          * *        ║");
        System.out.println("║                         *   *       ║");
        System.out.println("║                                     ║");
        System.out.println("╚═════════════════════════════════════╝");

        nextFrame();

        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                        *     *      ║");
        System.out.println("║                         *   *       ║");
        System.out.println("║                          * *        ║");
        System.out.println("║         " + winner + "                -*         ║");
        System.out.println("║                          * *        ║");
        System.out.println("║                         *   *       ║");
        System.out.println("║                        *     *      ║");
        System.out.println("╚═════════════════════════════════════╝");

        nextFrame();

        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                        *     *      ║");
        System.out.println("║                         *   *       ║");
        System.out.println("║                                     ║");
        System.out.println("║         " + winner + "                           ║");
        System.out.println("║                                     ║");
        System.out.println("║                         *   *       ║");
        System.out.println("║                        *     *      ║");
        System.out.println("╚═════════════════════════════════════╝");

        nextFrame();

        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                        *     *      ║");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("║         " + winner + "                           ║");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("║                        *     *      ║");
        System.out.println("╚═════════════════════════════════════╝");

        nextFrame();

        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("║         " + winner + "                           ║");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("╚═════════════════════════════════════╝");
    }

    private static void topHalf() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.print("║         ");
    }

    private static void bottomHalf() {
        System.out.println("         ║");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("║                                     ║");
        System.out.println("╚═════════════════════════════════════╝");
    }

    private static void nextFrame() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
