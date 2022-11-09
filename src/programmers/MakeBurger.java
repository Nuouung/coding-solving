package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MakeBurger {

    final int EMPTY = 5;
    
    boolean processOver = false;

    public static void main(String[] args) {
        MakeBurger b = new MakeBurger();
        b.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1});
    }

    public int solution(int[] ingredient) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : ingredient) {
            stack.push(i);

            if (stack.size() >= 4) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                Integer c = stack.pop();
                Integer d = stack.pop();

                if (a == 1 && b == 3 && c == 2 && d == 1) {
                    answer++;
                } else {
                    stack.push(d);
                    stack.push(c);
                    stack.push(b);
                    stack.push(a);
                }
            }
        }

        return answer;
    }
}
