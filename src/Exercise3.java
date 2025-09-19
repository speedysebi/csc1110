/*
 * Course: CSC1110
 * Loop Exercise
 * Fall 2025
 * Sebastien Huelke
 * 9/18/2025
 */

import java.util.Scanner;

/**
 * This class will count the number of vowels (a, e, i, o, u)
 * in a given word and display the result. It will do this
 * three times, using a different type of loop each time
 */
public class Exercise3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        do {
            System.out.print("Enter a word of at least 3 letters or 'q' to quit: ");
            String word = in.nextLine();
            if (word.equalsIgnoreCase("q")) {
                done = true;
            }

            if (word.length() >= 3) {
                int vowels = 0;

                // ----- for loop -----
                for (int i = 0; i < word.length(); i++) {
                    if (isVowel(word.charAt(i))) {
                        vowels++;
                    }
                }
                report(word, vowels);

                // ----- while loop -----
                vowels = 0;
                int i = 0;
                while (i < word.length()) {
                    if (isVowel(word.charAt(i))) {
                        vowels++;
                    }
                    i++;
                }
                report(word, vowels);

                // ----- do-while loop -----
                vowels = 0;
                int m = 0;
                do {
                    if (isVowel(word.charAt(m))) {
                        vowels++;
                    }
                    m++;
                } while (m < word.length());
                report(word, vowels);
            }

        } while (!done); // <-- closes the outer input loop

        System.out.println("Exiting...");
        in.close();
    }

    private static void report(String word, int vowels) {
        System.out.println(word + " contains " + vowels + " vowel" + (vowels == 1 ? "" : "s") + ".");
    }

    private static boolean isVowel(char c) {
        char ch = Character.toLowerCase(c);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
