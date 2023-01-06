package baekjoon.twoDimensionalArray;

import java.util.Scanner;

public class PlusArray {

    public static void main(String[] args) {
        // 3 3
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int N = Integer.parseInt(s.split(" ")[0]);
        int M = Integer.parseInt(s.split(" ")[1]);

        int[][] array1 = new int[N][M];
        initArray(in, array1);
        int[][] array2 = new int[N][M];
        initArray(in, array2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(array1[i][j] + array2[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void initArray(Scanner in, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = in.nextInt();
            }
        }
    }
}
