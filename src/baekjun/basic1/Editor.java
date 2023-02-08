package baekjun.basic1;

import java.io.*;
import java.util.Stack;

public class Editor {

    static Stack<Character> leftStack = new Stack<>();
    static Stack<Character> rightStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initStack(br);
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            solution(br.readLine().split(" "));
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }

    private static void initStack(BufferedReader br) throws IOException {
        for (char c : br.readLine().toCharArray()) {
            leftStack.push(c);
        }
    }

    static void solution(String[] operations) {
        switch (operations[0].charAt(0)) {
            case 'L' :
                if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                return;
            case 'D' :
                if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                return;
            case 'B' :
                if (!leftStack.isEmpty()) leftStack.pop();
                return;
            case 'P' :
                leftStack.push(operations[1].charAt(0));
        }
    }
}
