package programmers;

import java.util.*;

public class CalculateMax {

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";

        CalculateMax c = new CalculateMax();
        System.out.println(c.solution(expression));
    }

    long result = 0;

    List<Long> numbers = new ArrayList<>();
    List<Character> operations = new ArrayList<>();

    char[] operationBox = {'*', '+', '-'};
    boolean[] visited = new boolean[3];

    public long solution(String expression) {
        bindData(expression);
        permutation(new char[3], 0, 3);

        return result;
    }

    private void bindData(String expression) {
        StringBuilder number = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (isNumberValue(c)) {
                number.append(c);
                continue;
            }

            numbers.add(Long.parseLong(number.toString()));
            number = new StringBuilder();

            operations.add(c);
        }

        numbers.add(Long.parseLong(number.toString()));
    }

    boolean isNumberValue(char c) {
        return 48 <= c && c <= 57;
    }

    void permutation(char[] operationOrder, int depth, int r) {
        if (depth == r) {
            long calculated = calculate(operationOrder);
            if (calculated > result) result = calculated;
            return;
        }

        for (int i = 0; i < operationBox.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                operationOrder[depth] = operationBox[i];
                permutation(operationOrder, depth + 1, r);

                visited[i] = false;
            }
        }
    }

    long calculate(char[] operationOrder) {
        List<Long> tempNumbers = new ArrayList<>(numbers);
        List<Character> tempOperations = new ArrayList<>(operations);


        for (char operation : operationOrder) {
            for (int i = 0; i < tempOperations.size(); i++) {
                if (tempOperations.get(i) == operation) {
                    setCalculatedValue(tempNumbers, calculate(tempNumbers.get(i), tempNumbers.get(i + 1), operation), i, i + 1);
                    removeUsedOperation(tempOperations, i);

                    i--;
                }
            }
        }

        return Math.abs(tempNumbers.get(0));
    }

    void removeUsedOperation(List<Character> tempOperations, int index) {
        tempOperations.remove(index);
    }

    void setCalculatedValue(List<Long> tempNumbers, long calculatedValue, int leftIndex, int rightIndex) {
        tempNumbers.remove(rightIndex);
        tempNumbers.remove(leftIndex);

        tempNumbers.add(leftIndex, calculatedValue);
    }

    long calculate(long a, long b, char operation) {
        switch (operation) {
            case '*' :
                return a * b;
            case '+' :
                return a + b;
            case '-' :
                return a - b;
        }

        return -1;
    }
}
