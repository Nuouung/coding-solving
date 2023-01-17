package programmers;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class TargetNumber {

    public static void main(String[] args) {
        TargetNumber t = new TargetNumber();
        System.out.println(t.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    /*public int solution(int[] numbers, int target) {
        return dfs(numbers, target) / 2;
    }*/

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }

    int dfs(int[] numbers, int target) {

        int result = 0;

        int[] operation = new int[numbers.length];
        Stack<Graph> stack = new Stack<>();

        stack.push(new Graph(0, 0));
        stack.push(new Graph(0, 1));

        while (!stack.isEmpty()) {
            Graph current = stack.pop();

            if (current.depth < numbers.length) {
                stack.push(new Graph(current.depth + 1, 0));
                stack.push(new Graph(current.depth + 1, 1));

                operation[current.depth] = current.operation;
                continue;
            }

            int amount = 0;
            for (int i = 0; i < numbers.length; i++) {
                int value = (operation[i] == 1) ? numbers[i] : numbers[i] * -1;
                amount = amount + value;
            }

            if (amount == target) result++;
        }

        return result;
    }

    class Graph {
        int depth, operation; // 0 = (-) , 1 = (+)

        Graph(int depth, int operation) {
            this.depth = depth;
            this.operation = operation;
        }
    }
}
