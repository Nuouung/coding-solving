package baekjoon.strings;

import java.util.Scanner;

public class SearchingAlphabet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        int[] answerArray = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 97;

            if (i == 0) {
                answerArray[index] = -2;
                continue;
            }

            if (answerArray[index] == 0) {
                answerArray[index] = i;
            }
        }

        for (int i = 0; i < answerArray.length; i++) {
            if (answerArray[i] == 0) {
                answerArray[i] = -1;
            }

            if (answerArray[i] == -2) {
                answerArray[i] = 0;
            }
        }

        for (int i = 0; i < answerArray.length; i++) {
            if (i == 0) {
                System.out.print(answerArray[i]);
                continue;
            }

            System.out.print(" " + answerArray[i]);
        }
    }

}
