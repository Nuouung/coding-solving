package baekjoon.strings;

import java.util.Scanner;

public class NumberOfWords {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();

        boolean check = true;
        if (sentence.charAt(0) == 32 && sentence.length() == 1) {
            System.out.println(0);
            check = false;
        }

        if (sentence.charAt(0) == 32) {
            sentence = sentence.substring(1);
        }

        if (check) {
            String[] s = sentence.split(" ");
            System.out.println(sentence.split(" ").length);
        }
    }

}
