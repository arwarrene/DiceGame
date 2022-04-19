/**
 * Name: Audrey Warrene
 * Date: 02/18/2022
 * Class: CSC-331-001
 * Purpose: This is the getter and setter class for our needed parts of the dice game.
 *  This class also includes the rolling of the dice; a random number 1-6
 */

import java.security.SecureRandom;
public class Die {
    /**
     * This method holds all the private variables needed for a die
     */
    private static final SecureRandom randomSide = new SecureRandom();
    private static int numSides;
    private static String primaryColor;
    private static String secondaryColor;
    private static String numColor;
    private static int[] sideValues;

    public Die(int numSides, String primaryColor, String secondaryColor, String numColor, int[] sideValues) {
        /**
         * This is the constructor for our Die Game, and sets the variables
         */
        this.numSides = numSides;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.numColor = numColor;
        this.sideValues = sideValues;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

    public static int getNumSides() {
        /**
         * Returns the amount of sides on the die
         */
        return numSides;
    }

    public void setPrimaryColor(String primaryColor) {
        /**
         * This method lets the user pick a color for the die, and sets it
         */
        this.primaryColor = primaryColor;
    }

    public static String getPrimaryColor() {
        /**
         * This method returns that given color
         */
        return primaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        /**
         * This method lets the user choose a secondary color, and sets it
         */
        this.secondaryColor = secondaryColor;
    }

    public static String getSecondaryColor() {
        /**
         * This method returns that given color
         */
        return secondaryColor;
    }

    public void setNumColor(String numColor) {
        /**
         * This method lets the user choose the numbers' color on the die, and sets it
         */
        this.numColor = numColor;
    }

    public static String getNumColor() {
        /**
         * This method returns that given color
         */
        return numColor;
    }

    public void setSideValues(int[] sideValues) {
        /**
         * This method sets the array of the sides on the die
         */
        this.sideValues = sideValues;
    }

    public static int[] getSideValues() {
        /**
         * This method returns the given sides to the console
         */
        return sideValues;
    }

    public static int roll() {
        /**
         * When this method is called, a random number 1-6 is rolled and returned.
         */
        int dieNumber = 1 + randomSide.nextInt(6);
        return dieNumber;
    }
};
