package baekjoon.strings;

import java.util.Scanner;

public class StudyString {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String word = in.next();

        int[] alphabetArray = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int current = word.charAt(i) - 65;

            if (current >= 32) {
                current -= 32;
                alphabetArray[current] += 1;
                continue;
            }

            alphabetArray[current] += 1;
        }

        int biggestCount = 0;
        int biggestIndex = 0;
        for (int i = 0; i < alphabetArray.length; i++) {
            if (alphabetArray[i] > biggestCount) {
                biggestCount = alphabetArray[i];
                biggestIndex = i;
            }
        }

        boolean check = true;
        for (int i = 0; i < alphabetArray.length; i++) {
            if (i != biggestIndex && biggestCount == alphabetArray[i]) {
                System.out.println("?");
                check = false;
                break;
            }
        }

        if (check) {
            System.out.println(Character.toString(biggestIndex + 65));
        }

    }

}
