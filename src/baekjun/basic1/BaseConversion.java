package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaseConversion {

    static Stack<Integer> stackA = new Stack<>();
    static Stack<Integer> stackB = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);

        int n = Integer.parseInt(br.readLine());
        String[] ss = br.readLine().split(" ");
        for (String value : ss)
            stackA.push(Integer.parseInt(value));

        int decimal = getDecimal(A);
        setStackB(B, decimal);

        StringBuilder sb = new StringBuilder();
        while (!stackB.isEmpty()) {
            sb.append(stackB.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static void setStackB(int B, int decimal) {
        if (decimal == 0) {
            stackB.push(0);
            return;
        }

        while (decimal > 0) {
            stackB.push(decimal % B);
            decimal = decimal / B;
        }
    }

    static int getDecimal(int A) {
        int result = 0;

        int multiplier = 0;
        while (!stackA.isEmpty()) {
            result = (int) (result + stackA.pop() * Math.pow(A, multiplier));
            multiplier++;
        }

        return result;
    }
}
