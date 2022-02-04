package baekjoon.basicmath2;

import java.util.Arrays;
import java.util.Scanner;

public class RightAngledTriangle {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {

            int[] array = new int[3];
            array[0] = in.nextInt();
            array[1] = in.nextInt();
            array[2] = in.nextInt();

            if (array[0] == 0) {
                break;
            }

            Arrays.sort(array);

            if (Math.pow(array[0], 2) + Math.pow(array[1], 2) == Math.pow(array[2], 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

    }

}
