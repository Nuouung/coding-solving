package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

public class BiggerNumber2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] numbers = getNumbers(br);
        int[] biggerNumbers = createBiggerNumbers(numbers, createMyMap(numbers));

        solution(numbers, biggerNumbers);

        for (int number : numbers) {
            sb.append(number).append(" ");
        }

        System.out.println(sb);
    }

    static void solution(int[] numbers, int[] biggerNumbers) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            if (biggerNumbers[i] >= biggerNumbers[i + 1]) {
                stack.push(i);
                continue;
            }

            numbers[i] = numbers[i + 1];
            while (!isEmptyOrBigger(stack, biggerNumbers, i)) {
                numbers[stack.pop()] = numbers[i + 1];
            }
        }

        while (!stack.isEmpty()) {
            numbers[stack.pop()] = -1;
        }

        numbers[numbers.length - 1] = -1;
    }

    static boolean isEmptyOrBigger(Stack<Integer> stack, int[] biggerNumbers, int i) {
        return stack.isEmpty() || biggerNumbers[stack.peek()] >= biggerNumbers[i + 1];
    }

    static int[] getNumbers(BufferedReader br) throws IOException {
        String s = br.readLine(); // 버리는 거

        return Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[] createBiggerNumbers(int[] numbers, Map<Integer, Integer> myMap) {
        int[] biggerNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            biggerNumbers[i] = myMap.get(numbers[i]);
        }
        return biggerNumbers;
    }

    private static Map<Integer, Integer> createMyMap(int[] numbers) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int number : numbers) {
            if (myMap.get(number) == null) {
                myMap.put(number, 1);
                continue;
            }

            myMap.put(number, myMap.get(number) + 1);
        }

        return myMap;
    }
}
