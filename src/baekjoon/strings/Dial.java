package baekjoon.strings;

import java.util.Scanner;

public class Dial {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String word = in.next();

        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += returnNumber(String.valueOf(word.charAt(i)));
        }
        System.out.println(sum);
    }

    public static int returnNumber(String s) {
        switch (s) {
            case "A": case "B": case "C":
                return 1 + 2;
            case "D": case "E": case "F":
                return 2 + 2;
            case "G": case "H": case "I":
                return 3 + 2;
            case "J": case "K": case "L":
                return 4 + 2;
            case "M": case "N": case "O":
                return 5 + 2;
            case "P": case "Q": case "R": case "S":
                return 6 + 2;
            case "T": case "U": case "V":
                return 7 + 2;
            case "W": case "X": case "Y": case "Z":
                return 8 + 2;
        }
        return -1;
    }
}
