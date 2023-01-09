package programmers;

import java.util.Scanner;

public class PrintStar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[][] array = new int[b][a];
        for (int[] innerArray : array) {
            for (int i : innerArray) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
