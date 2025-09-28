/*
* CSC 1110-141
* Variable Name Checker
* Fall 2025
* Sebastien Huelke
* 9/27/2025
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This program checks the properness of a proposed Java variable name.");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a variable name (q to quit): ");
            String name = in.nextLine();
            if (name.equals("q")) break;
            if (!isLegalJavaName(name)) {
                System.out.println("Illegal.");
            } else if (isGoodStyle(name)) {
                System.out.println("Good!");
            } else {
                System.out.println("Legal, but uses poor style.");
            }
        }
    }
    // The general rules for naming variables are:
    // Names can contain letters, digits, underscores, and dollar signs
    // Names must begin with a letter
    // Names should start with a lowercase letter, and cannot contain whitespace
    // Names can also begin with $ and _
    // Names are case-sensitive ("myVar" and "myvar" are different variables)
    // Reserved words (like Java keywords, such as int or boolean) cannot be used as names
    // this is according to : https://www.w3schools.com/java/java_variables_identifiers.asp
    // for this assignment here are the guidelines:
    // only letters and digits, first character is a lowercase letter
    public static boolean isLegalJavaName(String s) {
        if (s == null || s.isEmpty()) return false;
        char first = s.charAt(0);
        if (Character.isDigit(first) || Character.isWhitespace(first)) return false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isWhitespace(ch)) return false;
            if (Character.isLetterOrDigit(ch) || ch == '_' || ch == '$') continue;
            return false;
        }
        return true;
    }
    // a variable is in proper style
    // only letters and digits, first character is a lowercase letter
    public static boolean isGoodStyle(String s) {
        if (!Character.isLowerCase(s.charAt(0))) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetterOrDigit(s.charAt(i))) return false;
        }
        return true;
    }
}
