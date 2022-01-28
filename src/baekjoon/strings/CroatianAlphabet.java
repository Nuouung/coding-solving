package baekjoon.strings;

import java.util.Scanner;

public class CroatianAlphabet {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String alphabet = in.next();

        String[] croatianAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String s : croatianAlphabet) {
            if (alphabet.contains(s)) {
                alphabet = alphabet.replace(s, "C");
            }
        }

        System.out.println(alphabet.length());
    }

}
