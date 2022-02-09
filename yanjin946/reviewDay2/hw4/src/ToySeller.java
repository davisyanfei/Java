import java.util.Scanner;

/**
 * A program that determines the price of a custom-made toy.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 04 -- Challenge
 *
 * @author Purdue CS
 * @version August 23, 2021
 */

public class ToySeller {

    private static String welcomeMessage = "Welcome to the Custom Toy Builder!\nOur store can custom-design " +
            "3 different types of toys.";
    private static String startMessage = "Which would you like to create? (Enter a number)\n" +
            "1. Superman figurine\n" +
            "2. Robotic cyclops\n" +
            "3. Cat-shaped lamp\n" +
            "4. EXIT";

    private static String endProgram = "Thanks for using the Custom Toy Builder!";

    private static String sizeQuestion = "What size toy would you like? (Enter S, M, or L)";
    private static String supermanQ1 = "Do you want Superman to talk? (Enter Y or N)";
    private static String supermanQ2 = "Do you want to add a cape? (Enter Y or N)";
    private static String roboticCyclopsQ1 = "Do you want the Robotic Cyclops to move? (Enter Y or N)";
    private static String roboticCyclopsQ2 = "What color eye do you want? (Enter 1, 2, or 3)\n" +
            "1. Red\n" +
            "2. Yellow\n" +
            "3. Blue";
    private static String catLampQ1 = "What color Cat-shaped Lamp do you want? (Enter 1, 2, 3, or 4)\n" +
            "1. Gold\n" +
            "2. Pink\n" +
            "3. Blue\n" +
            "4. No Color";
    private static String catLampQ2 = "Do you want the Cat-shaped Lamp to glow? (Enter Y or N)";

    private static String supermanCost = "Your Superman figurine costs";
    private static String roboticCyclopsCost = "Your Robotic Cyclops costs";
    private static String catLampCost = "Your Cat-shaped Lamp costs";

    public  void  b(){
        ToySeller toySeller=new ToySeller();
        toySeller.welcomeMessage = "cxxxx";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPrice = 0;

        System.out.println(welcomeMessage);
        System.out.println(startMessage);

        int toyType = scanner.nextInt();
        if ( toyType == 1) {

            System.out.println(sizeQuestion);
            String toySize = scanner.next();

            if (toySize.equals("S") ) {
                totalPrice = 5;
            } else if (toySize.equals("M") ) {
                totalPrice = 10 ;
            } else if (toySize.equals("L") ) {
                totalPrice = 15;
            }

            scanner.nextLine();
            System.out.println(supermanQ1);
            String toyTalk = scanner.nextLine();

            if (toyTalk.equals("Y") ) {
                totalPrice = totalPrice + 8;
            } else if (toyTalk.equals("N") ) {
                totalPrice = totalPrice + 4;
            }

            System.out.println(supermanQ2);
            String toyCape = scanner.nextLine();

            if (toyCape.equals("Y") ) {
                totalPrice = totalPrice + 5;
            } else if (toyCape.equals("N") ) {
                totalPrice = totalPrice + 0;
            }

            System.out.printf("%s $%d!\n", supermanCost, totalPrice);
            System.out.println(endProgram);
        }

        if ( toyType == 2) {

            System.out.println(sizeQuestion);
            String toySize = scanner.next();

            if (toySize.equals("S") ) {
                totalPrice = 5;
            } else if (toySize.equals("M") ) {
                totalPrice = 10 ;
            } else if (toySize.equals("L") ) {
                totalPrice = 15;
            }

            scanner.nextLine();
            System.out.println(roboticCyclopsQ1);
            String toyMove = scanner.nextLine();

            if (toyMove.equals("Y") ) {
                totalPrice = totalPrice + 5;
            } else if (toyMove.equals("N") ) {
                totalPrice = totalPrice + 3;
            }

            System.out.println(roboticCyclopsQ2);
            int toyEyeColor = scanner.nextInt();

            if (toyEyeColor == 1) {
                totalPrice = totalPrice + 5;
            } else if (toyEyeColor == 2) {
                totalPrice = totalPrice + 6;
            } else if (toyEyeColor == 3) {
                totalPrice = totalPrice + 7;
            }

            System.out.printf("%s $%d!\n", roboticCyclopsCost, totalPrice);
            System.out.println(endProgram);
        }
        if ( toyType == 3) {

            System.out.println(sizeQuestion);
            String toySize = scanner.next();

            if (toySize.equals("S") ) {
                totalPrice = 5;
            } else if (toySize.equals("M") ) {
                totalPrice = 10 ;
            } else if (toySize.equals("L") ) {
                totalPrice = 15;
            }

            scanner.nextLine();
            System.out.println(catLampQ1);
            int toyLamp = scanner.nextInt();

            if (toyLamp == 1) {
                totalPrice = totalPrice + 10;
            } else if (toyLamp == 2) {
                totalPrice = totalPrice + 7;
            } else if (toyLamp == 3) {
                totalPrice = totalPrice + 7;
            } else if (toyLamp == 4) {
                totalPrice = totalPrice + 5;
            }

            scanner.nextLine();
            System.out.println(catLampQ2);
            String toyGlow = scanner.nextLine();

            if (toyGlow.equals("Y") ) {
                totalPrice = totalPrice + 10;
            } else if (toyGlow.equals("N")) {
                totalPrice = totalPrice + 0;
            }


            System.out.printf("%s $%d!\n", catLampCost, totalPrice);

            System.out.println(endProgram);
        }
        if (toyType == 4) {

            System.out.println(endProgram);
        }
    }
}