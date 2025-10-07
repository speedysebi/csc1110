/*
 * Course: CSC1110 - 141
 * Fall 2025
 * Lab 5 - Growth rate
 * Name: Sebastien Huelke
 * Created: 9/25/2025
 */

package huelkes;

import java.util.Scanner;
import java.util.Random;

public class GrowthRate {

    // Pretty numbers with commas, e.g., 10,000
    private static String fmt(int n) {
        return String.format("%,d", n);
    }

    public static void main(String[] args) {

        String answer;
        do {

            // initiating a new random number
            Random random = new Random();
            // generating random number between 200 and 2000 for the linear route
            int min = 200;
            int max = 2001;
            int linearProgression = random.nextInt(max - min) + min;

            // generating random number for the amount of harvests
            int min2 = 1;
            int max2 = 31;
            int howManySwings = random.nextInt(max2 - min2) + min2;

            // scanner in to read what user inputs
            Scanner in = new Scanner(System.in);

            // story (replaces the old rutabaga narrative; variables unchanged)
            System.out.println(
                    "Every single day during the summer, you swing on the swing in your back yard. Butterflies flutter by,\n " +
                            "and every once in a while you go inside for a drink of water. But every time you go back.\n Between lunch " +
                            "and dinner, like clockwork you go outside to sit on your swing without a care in the world. \nMaybe later you " +
                            "will play a board game, or maybe later you will watch a movie with your siblings."
            );

            System.out.println(
                    "This goes on every year, until you are almost 10 years old, then at the beginning of your summer, \n" +
                            "your mother goes on to tell you that you can only swing on the swing so many times."
            );

            System.out.println();
            System.out.println(
                    "Would you rather start out with " + fmt(linearProgression) + " swings a day,\n " +
                            "or would you like to start with one swing today, but it will double with every passing day?"
            );


            // choice prompt (number formatted)
            System.out.println("Enter \"1\" if you would prefer to receive " + fmt(linearProgression) + " swings each day,\n" +
                    "or enter \"2\" if you would rather risk exponential growth: ");
            int risky = in.nextInt();

            int linTotal = 0;
            int expTotal = 0;

            for (int day = 1; day <= howManySwings; day++) {
                expTotal = (1 << day) - 1;
                linTotal = linearProgression * day;

                // print only while exponential is strictly less than linear, with alignment + commas
                if (expTotal < linTotal) {
                    System.out.println(String.format(
                            "Harvest %2d    Linear: %9s,    Exponential: %9s",
                            day, fmt(linTotal), fmt(expTotal)
                    ));
                }
            }

            int diff = Math.abs(linTotal - expTotal);

            if (linTotal == expTotal) {
                System.out.println("You broke even after " + howManySwings + " swing(s).");
            } else if (risky == 1) {
                if (linTotal > expTotal) {
                    System.out.println("You're lucky! You made " + fmt(diff) + " swings more.");
                } else {
                    System.out.println("Unlucky — you lost " + fmt(diff) + " swings.");
                }
            } else if (risky == 2) {
                if (expTotal > linTotal) {
                    System.out.println("You're lucky! You made " + fmt(diff) + " swings more.");
                } else {
                    System.out.println("Unlucky — you lost " + fmt(diff) + " swings.");
                }
            }

            System.out.println("Do you want to play again? (Y/N)?");
            answer = in.next();

        } while (answer.equalsIgnoreCase("Y"));
    }
}
