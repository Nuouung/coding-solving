package programmers;

import java.util.Stack;

public class DeliveryBox {

    public static void main(String[] args) {
        DeliveryBox d = new DeliveryBox();
        System.out.println(d.solution(new int[]{4, 3, 1, 2, 5}));
    }

    Stack<Integer> stack = new Stack<>();

    public int solution(int[] order) {
        int result = 0;
        int current = 1;
        for (int value : order) {
            while (current < value) {
                stack.push(current++);
            }

            if (current == value) {
                result++;
                current++;
                continue;
            }

            if (stack.peek() == value) {
                stack.pop();
                result++;
                continue;
            }

            break;
        }

        return result;
    }
}
