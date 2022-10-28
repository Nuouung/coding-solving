package baekjoon.basic2;

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarf {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] heights = new int[9];
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = in.nextInt();
            heights[i] = height;
            total += height;
        }

        int[] sevenDwarf = new int[7];
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                for (int k = j + 1; k < heights.length; k++) {
                    if (heights[i] + heights[j] + heights[k] == (total - 100)) {
                        for (int a = 0; a < heights.length; a++) {
                            if (a != i && a != j && a != k) {
                                sevenDwarf[a] = heights[a];
                            }
                        }
                    }
                }
            }
        }

        Arrays.sort(sevenDwarf);

        for (int i : sevenDwarf) {
            System.out.println(i);
        }
    }
}
