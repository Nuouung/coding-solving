package baekjoon.strings;

import java.util.Scanner;

public class GroupWord {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int count = 0;
        for (int i = 0; i < N; i++) {
            String compressedWord = createCompressedWord(in);
            boolean check = isCheck(compressedWord);
            if (check) count++;
        }

        System.out.println(count);
    }

    private static boolean isCheck(String compressedWord) {
        int[] alphabet = new int[26];
        boolean check = true;
        for (int j = 0; j < compressedWord.length(); j++) {
            int index = compressedWord.charAt(j) - 97;
            if (alphabet[index] == 0) {
                alphabet[index] = 1;
                continue;
            }

            if (alphabet[index] == 1) {
                check = false;
                break;
            }
        }
        return check;
    }

    private static String createCompressedWord(Scanner in) {
        StringBuilder word = new StringBuilder();
        word.append(in.next());

        int k = word.length();
        for (int j = 0; j < k; j++) {
            if (j != word.length() - 1) {
                if (word.charAt(j) == word.charAt(j + 1)) {
                    word.deleteCharAt(j + 1);
                    j--;
                }
            }
            k = word.length();
        }

        return word.toString();
    }

}
