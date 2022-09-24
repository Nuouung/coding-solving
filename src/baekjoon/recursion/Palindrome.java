package baekjoon.recursion;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            String s = in.next();

            Recursion recursion = new Recursion();
            recursion.doRecursion(s);

            int i1 = recursion.isPalindrome ? 1 : 0;
            System.out.println(i1 + " " + recursion.depth);
        }
    }

    static class Recursion {

        private int depth;
        private boolean isPalindrome;

        Recursion() {
            depth = 0;
            isPalindrome = false;
        }

        void doRecursion(String s) {
            recursion(s, 0, s.length() - 1);
        }

        private void recursion(String s, int start, int end) {
            depth++;

            if (start >= end) {
                isPalindrome = true;
                return;
            }

            if (s.charAt(start) != s.charAt(end)) {
                isPalindrome = false;
                return;
            }

            recursion(s, start + 1, end - 1);
        }
    }
}