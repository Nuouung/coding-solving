package baekjoon.strings;

import java.util.Scanner;

public class RepeatString {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        for (int i = 0; i < N; i++) {
            int repeatNumber = Integer.parseInt(in.next());
            String targetString = in.next();

            StringBuilder sum = new StringBuilder();
            for (int j = 0; j < targetString.length(); j++) {
                for (int k = 0; k < repeatNumber; k++) {
                    sum.append(targetString.charAt(j));
                }
            }
            System.out.println(sum);
        }

    }
}
