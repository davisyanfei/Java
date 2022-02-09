import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Project 3 - PlayGame
 *
 * <p> Purdue University -- CS 180 -- 2021</p>
 *
 * @author Jin Yan Purdue CS
 *
 * @version Oct 30, 2021
 */

public class PlayGame {

    public static void main(String[] args) throws Exception {

        ArrayList<String> list1 = new ArrayList<String>();
        File f1 = new File("ShipPositionsPlayerOne.txt");
        FileReader fr1 = new FileReader(f1);
        BufferedReader bfr1 = new BufferedReader(fr1);

        try {
            String line = bfr1.readLine();
            while (line!= null) {
                list1.add(line);
                line = bfr1.readLine();
            }
            bfr1.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

        ArrayList<String> list2 = new ArrayList<String>();
        File f2 = new File("ShipPositionsPlayerTwo.txt");
        FileReader fr2 = new FileReader(f2);
        BufferedReader bfr2 = new BufferedReader(fr2);

        try {
            String line = bfr2.readLine();
            while (line!= null) {
                list2.add(line);
                line = bfr2.readLine();
            }
            bfr2.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

        int topThree = 0;
        int middleFour = 0;
        int bottomThree = 0;
        int topThree2 = 0;
        int middleFour2 = 0;
        int bottomThree2 = 0;
        String pattern1 = "";
        String pattern2 = "";

        for (int i=0; i<10; i++) {
            for (int j= 0; j< 14; j++) {
                if(list1.get(i).charAt(j) == 'H') {
                    if(i <= 2) {
                        topThree ++;
                    } else if (i <= 6) {
                        middleFour ++;
                    } else {
                        bottomThree ++;
                    }
                }
                if(list2.get(i).charAt(j) == 'H') {
                    if (i <= 2) {
                        topThree2++;
                    } else if (i <= 6) {
                        middleFour2++;
                    } else {
                        bottomThree2++;
                    }
                }

            }
        }

        if (topThree >= 9) {
            pattern1 = "Top Heavy";
        } else if (middleFour >= 9) {
            pattern1 = "Middle Heavy";
        } else if (bottomThree >= 9) {
            pattern1 = "Bottom Heavy";
        } else {
            pattern1 = "Scattered";
        }

        if (topThree2 >= 9) {
            pattern2 = "Top Heavy";
        } else if (middleFour2 >= 9) {
            pattern2 = "Middle Heavy";
        } else if (bottomThree2 >= 9) {
            pattern2 = "Bottom Heavy";
        } else {
            pattern2 = "Scattered";
        }



        System.out.println("Hello, Welcome to Battleship!");

        int playerOneHit = 0;
        int playerTwoHit = 0;
        int playerGoes = 0;
        int rounds = 0;
        Scanner scanner = new Scanner(System.in);

        while (playerTwoHit != 17 && playerOneHit != 17) {
            if (playerGoes == 0) {
                System.out.println("Player 1 - Enter a row letter from A - J");
                String hitRow = scanner.nextLine();
                char hitRowChar = hitRow.charAt(0);
                int rowChar = hitRowChar - 65;
                System.out.println("Player 1 - Enter a column number from 1 - 14");
                int hitColumn = scanner.nextInt();
                scanner.nextLine();
                int columnChar = hitColumn - 1;
                if (hit(list2, rowChar, columnChar)) {
                    playerOneHit ++;
                }
                playerGoes = 1;
                rounds ++;

            } else {
                System.out.println("Player 2 - Enter a row letter from A - J");
                String hitRow = scanner.nextLine();
                char hitRowChar = hitRow.charAt(0);
                int rowChar = hitRowChar - 65;
                System.out.println("Player 2 - Enter a column number from 1 - 14");
                int hitColumn = scanner.nextInt();
                scanner.nextLine();
                int columnChar = hitColumn - 1;
                if (hit(list1, rowChar, columnChar)) {
                    playerTwoHit ++;
                }
                playerGoes = 0;
            }

        }

        int winner = 0;
        int loser = 0;

        if (playerOneHit == 17) {
            System.out.println("Enemy fleet destroyed. Congratulations player 1!");
            winner = 1;
            loser = playerTwoHit;
        } else {
            System.out.println("Enemy fleet destroyed. Congratulations player 2!");
            winner = 2;
            loser = playerOneHit;
        }

        GameLog gameText = new GameLog(winner, loser, rounds, pattern2, pattern1);
        String output = gameText.toString();
        PrintWriter writer = new PrintWriter("GameLog.txt");
        writer.println(output);
        writer.close();

    }

    public static boolean hit(ArrayList<String> list, int row, int column){
        String hitRow = list.get(row);
        char hitPoint = hitRow.charAt(column);
        if (hitPoint == 'H') {
            hitRow = hitRow.substring(0, column) + "M" + hitRow.substring(column+1);
            System.out.println("Value: H");
            list.set(row, hitRow);
            return true;
        } else {
            System.out.println("Value: M");
            return false;
        }
    }

}
