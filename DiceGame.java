/**
 * Name: Audrey Warrene
 * Date: 02/18/2022
 * Class: CSC-331-001
 * Purpose: This is the driver for the Die class we have created. It shows what we can do with our die class,
 * And then runs the "game" that the user can interact with. This method is shut down if the user doesn't play,
 * and/or after one turn.
 */

import java.util.Scanner;       //for input

public class DiceGame {
    public static void main(String[] args) {
        /**
         * This main method is displaying all the attributes of our die using the die class (this is just one example)
         * It also receives input from the user to see if they want to play the guessing game. If the user says no,
         * or enters something that is not (Y/N), the program halts. Otherwise, the game goes on. They see if they can
         * guess how many rolls it will take to get a randomly assigned dice number.
         */
        final int[] SIDES = {1,2,3,4,5,6};      //used just for personal readability
        Die dieMethod = new Die(6, "White", "Blue", "Black", SIDES); //Initializing our example of the die

        System.out.printf("%s%d%s%n", "There are ",dieMethod.getNumSides()," sides to the dice.");
        System.out.printf("%s%s%n", "The primary color of the dice is: ", dieMethod.getPrimaryColor());
        System.out.printf("%s%s%n", "The secondary color of the dice is: ", dieMethod.getSecondaryColor());
        System.out.printf("%s%s%n", "The color of the number(s) on the dice is: ", dieMethod.getNumColor());
        System.out.println("The numbers on the dice consist of: ");

        int[] sides = dieMethod.getSideValues();        //using get method to display values on dice
        for (int value : sides) {
            System.out.println(value);
        }

        boolean stop = false;       //Used so we can break out of statements within while loop if needed
        while (stop == false) {     //beginning of game
            System.out.println("\nDo you want to try and guess the amount of tries" +
                    " needed to roll a random die number? (Y/N): ");
            Scanner input = new Scanner(System.in);
            String user = input.next();
            String play = user.toUpperCase();       //Used in-case the user enters a "y or n" in lowercase letters

            if (play.equals("Y")) {     //Player does want to play if this passes
                int dieNumber = Die.roll();     //Uses the roll() method to determine a random side value that needs guessed
                System.out.println("The random number you have been given is " + dieNumber);   //Wasn't sure if I needed to do this, but made sense

                System.out.println("Guess how many rolls are needed to get the number " + dieNumber + ": ");
                Scanner guess = new Scanner(System.in);
                int guessRolls = guess.nextInt();       //This saves the users guess of how many rolls will be needed

                int randomRoll = Die.roll();        //First value checker, to see if it is rolled on the first try
                int tries = 1;


                if (randomRoll == dieNumber & guessRolls == tries) {        //guessed correctly on first roll
                    System.out.println("You got it! The number was " + dieNumber + " and that was rolled on your first try!");
                    stop = true;        //makes while loop not run again
                } else if (randomRoll == dieNumber & guessRolls != tries) {     //guessed incorrectly, was rolled on first try
                    System.out.println("The number " + dieNumber + " was rolled on the first try, which was not your guess. Yours was " + guessRolls + " tries.");
                    stop = true;    //makes while loop not run again
                } else {
                    boolean found = false;  //Used again for breaking out of separate while loop
                    while (found != true) {
                        int moreRandomRolls = Die.roll();       //starts rolling until given number is rolled
                        tries += 1;     //keeps track of how many rolls were needed
                        if (moreRandomRolls == dieNumber) {
                            found = true;       //once found, breaks out of while loop
                        };
                    };
                    if (tries != guessRolls) {      //They did not guess correctly how many rolls were needed
                        if (guessRolls == 1) {      //grammar decider**
                            System.out.println("The number " + dieNumber + " was rolled, but after " + tries + " tries. " +
                                    "That was not equal to your guess of " + guessRolls + " rolls.");
                            stop = true;
                        } else {        //grammar decider**
                            System.out.println("The number " + dieNumber + " was rolled, but after " + tries + " tries. " +
                                    "That was not equal to your guess of " + guessRolls + " rolls.");
                            stop = true;
                        }
                    } else {        //They guessed the rolls correctly, and it was not the first roll!
                        System.out.println("The number " + dieNumber + " was rolled on the same roll you guessed," +
                                " which was " + guessRolls + "! You win!");
                        stop = true;
                    }
                }

            } else if (play.equals("N")) {      //player doesn't want to play
                stop = true;        //breaks out of game
                System.out.println("Okay! Thanks.\n");
                break;

            } else {        //if something is entered that is not (Y/N)
                throw new IllegalArgumentException("That response was not a Y/N, please try again later.\n");
            };
        };
    };
};
