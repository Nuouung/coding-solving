package baekjoon.bruteForce;

import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int newCard = arr[i] + arr[j] + arr[k];
                    if (newCard <= target && newCard > max) {
                        max = newCard;
                    }
                }
            }
        }
        System.out.println(max);

    }

}
