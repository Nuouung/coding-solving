package baekjoon.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrintStars {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        List<List<Integer>> numberList = new ArrayList<>();
        while (N > 0) {
            List<Integer> innerList = new ArrayList<>();
            innerList.add(in.nextInt());
            innerList.add(in.nextInt());

            numberList.add(innerList);
            N--;
        }

//        Collections.sort(numberList);
    }

}
