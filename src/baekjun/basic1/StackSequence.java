package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int current = 1;
        int[] sequence = getSequence(br, n);
        Stack<Integer> stack = new Stack<>();;

        for (int i = 0; i < sequence.length; i++) {

            if (!isReachable(sequence[i], current, stack.peek())) {
                System.out.println("NO");
                return; // 종료
            }

            if (!stack.isEmpty()) {
                if (isEqual(sequence[i], stack.peek())) {
                    stack.pop();
                    sb.append("-").append("\n");
                    continue;
                }
            }

            while (current <= sequence[i]) {
                stack.push(current++);
                sb.append("+").append("\n");
            }

            i--;
        }

        System.out.println(sb);
    }

    private static boolean isEqual(int target, int peek) {
        return target == peek;
    }

    static int[] getSequence(BufferedReader br, int n) throws IOException {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        return array;
    }

    static boolean isReachable(int target, int current, int peek) {
        return target >= current || isEqual(target, peek);
    }
}
