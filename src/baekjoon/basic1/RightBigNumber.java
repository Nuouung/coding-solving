package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RightBigNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] sBox = br.readLine().split(" ");
        int[] box = new int[sBox.length];
        for (int i = 0; i < sBox.length; i++) {
            box[i] = Integer.parseInt(sBox[i]);
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < box.length - 1; i++) {

            if (box[i] >= box[i + 1]) {
                stack.push(i);
            } else {

                box[i] = box[i + 1];
                while (!stack.isEmpty() && box[stack.peek()] < box[i + 1]) {
                    Integer index = stack.pop();
                    box[index] = box[i + 1];
                }

            }

        }

        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            box[index] = -1;
        }

        box[box.length - 1] = -1;

        for (int i : box) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
