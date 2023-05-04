package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakeCrypto {

    static String[] storage;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();
        int cryptoLength = Integer.parseInt(temp.split(" ")[0]);

        String[] array = new String[Integer.parseInt(temp.split(" ")[1])];
        String[] temp2 = br.readLine().split(" ");
        System.arraycopy(temp2, 0, array, 0, array.length);
        Arrays.sort(array);

        storage = new String[cryptoLength];

        recursion(array, 0, 0, cryptoLength);
    }

    static void recursion(String[] array, int depth, int start, int cryptoLength) {
        if (depth == cryptoLength) {
            if (countJaum() >= 2 && countMoum() >= 1) {
                StringBuilder sb = new StringBuilder();
                for (String s : storage) {
                    sb.append(s);
                }

                System.out.println(sb);
            }

            return;
        }

//        storage[depth] = array[start];

        for (int i = start; i < array.length; i++) {
            storage[depth] = array[i];
            recursion(array, depth + 1, i + 1, cryptoLength);
        }
    }

    static int countJaum() {
        int jaumNumber = 0;
        for (String s : storage) {
            if (!isMoum(s)) jaumNumber++;
        }

        return jaumNumber;
    }

    private static boolean isMoum(String s) {
        return s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u");
    }

    static int countMoum() {
        int moumNumber = 0;
        for (String s : storage) {
            if (isMoum(s)) moumNumber++;
        }

        return moumNumber;
    }
}
