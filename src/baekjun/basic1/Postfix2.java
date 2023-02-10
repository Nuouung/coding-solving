package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Postfix2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String data = br.readLine();
        double[] array = createArray(br, n);
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < data.length(); i++) {
            solution(stack, data.charAt(i), array);
        }

        System.out.printf("%.2f", stack.pop());
    }

    private static void solution(Stack<Double> stack, char c, double[] array) {
        if ('A' <= c && c <= 'Z') {
            stack.push(array[c - 'A']);
            return;
        }

        if (!stack.isEmpty()) {
            double first = stack.pop();
            double second = stack.pop();
            switch (c) {
                case '+' :
                    stack.push(first + second);
                    return;
                case '-' :
                    stack.push(second - first);
                    return;
                case '*' :
                    stack.push(first * second);
                    return;
                case '/' :
                    stack.push(second / first);
            }
        }
    }

    private static double[] createArray(BufferedReader br, int n) throws IOException {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = Double.parseDouble(br.readLine());
        }

        return array;
    }
}
