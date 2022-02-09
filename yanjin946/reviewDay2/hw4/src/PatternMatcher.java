import java.util.Scanner;
/**
 * A program of a calculation game.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 05 -- Challenge
 *
 * @author Purdue CS
 * @version September 30, 2021
 */
public class PatternMatcher {

    public static void main(String[] args) {

        String chooseLevel = "Choose Level Difficulty:" + "\n1. Easy\n2. Medium\n3. Hard";
        String startNumber = "Enter a number to start the pattern:";
        String nextThree = "Enter the next 3 numbers in the pattern:";
        String congratulations = "Congrats! Your answer was correct!";
        String sorry = "Sorry! Your answer was incorrect!";
        String again = "Play Game Again? (y/n)";
        String ending = "Ending Pattern Matcher...";

        int number;
        String yesNo = "";
        do {

            Scanner scanner = new Scanner(System.in);
            System.out.println(chooseLevel);
            number = scanner.nextInt();
            System.out.println(startNumber);

            if (number == 1) {

                int numberOne = scanner.nextInt();
                System.out.println(nextThree);
                System.out.print(numberOne + " ");
                System.out.print(numberOne + 2 + " ");
                System.out.print(numberOne + 4 + " ");
                System.out.println(numberOne + 6);

                int oneNumber = scanner.nextInt();
                int twoNumber = scanner.nextInt();
                int threeNumber = scanner.nextInt();

                if (oneNumber == numberOne + 8 && twoNumber == numberOne + 10 && threeNumber == numberOne + 12) {
                    System.out.println(congratulations);
                } else {
                    System.out.println(sorry);
                }
            } else if (number == 2) {

                int numberTwo = scanner.nextInt();
                System.out.println(nextThree);
                System.out.print(numberTwo + " ");
                System.out.print(numberTwo * 4 + " ");
                System.out.print(numberTwo * 16 + " ");
                System.out.println(numberTwo * 64);

                int fourNumber = scanner.nextInt();
                int fiveNumber = scanner.nextInt();
                int sixNumber = scanner.nextInt();

                if (fourNumber == numberTwo * 256 && fiveNumber == numberTwo * 1024 && sixNumber == numberTwo * 4096) {
                    System.out.println(congratulations);
                }  else {
                    System.out.println(sorry);
                }

            } else if (number == 3) {

                int numberThree = scanner.nextInt();
                int main = numberThree + 1;
                int triple = numberThree + 2;
                int quadra = numberThree + 3;
                int penta = numberThree + 4;
                int hexa = numberThree + 5;
                int hepta = numberThree + 6;
                int pentaKill = penta * penta + 1;
                int hexaKill = hexa * hexa + 1;
                int heptaKill = hepta * hepta + 1;


                System.out.println(nextThree);
                System.out.print(numberThree * numberThree + 1 + " ");
                System.out.print(main * main + 1 + " ");
                System.out.print(triple * triple + 1 + " ");
                System.out.println(quadra * quadra + 1);

                int sevenNumber = scanner.nextInt();
                int eightNumber = scanner.nextInt();
                int nineNumber = scanner.nextInt();

                if (sevenNumber == pentaKill && eightNumber == hexaKill && nineNumber == heptaKill) {
                    System.out.println(congratulations);
                } else {
                    System.out.println(sorry);
                }

            } else {
                System.out.println(chooseLevel);
                int numberX = scanner.nextInt();
            }

            System.out.println(again);
            scanner.nextLine();
            yesNo = scanner.nextLine();




        } while (yesNo.equals("y") || (number != 1 && number != 2 && number !=3));

        System.out.println(ending);

    }
}
