package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronRod {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = solution(br.readLine());

        if (result == -1) throw new RuntimeException();
        System.out.println(result);
    }

    static int solution(String ironRods) {
        Stack<Character> stack = new Stack<>();
        boolean previousOpen = false;
        int result = 0;

        for (int i = 0; i < ironRods.length(); i++) {
            if (ironRods.charAt(i) == '(') {
                previousOpen = true;

                stack.push(ironRods.charAt(i));
                continue;
            }

            // 닫는 괄호만 올 수 있는 구간이므로 여기에 오는 모든 건 닫는 괄호임
            if (previousOpen) {
                previousOpen = false;

                stack.pop();
                result += stack.size();
                continue;
            }

            stack.pop();
            result++;
        }

        return stack.isEmpty() ? result : -1;
    }
}
