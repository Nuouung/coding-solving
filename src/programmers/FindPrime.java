package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class FindPrime {

    public static void main(String[] args) {
        FindPrime f = new FindPrime();
        System.out.println(f.solution("011"));
    }

    public int solution(String numbers) {
        int[] numberArray = new int[numbers.length()];
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = Character.getNumericValue(numbers.charAt(i));
        }

        int result = 0;

        boolean[] visited = new boolean[numberArray.length];

        for (int i = 0; i < numberArray.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(numberArray[i]);

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
            }
        }

        return result;
    }

    private int getNumber(int[] tempArray) {
        int multipleOfTen = tempArray.length - 1;
        int number = 0;
        for (int n : tempArray) {
            number += n * Math.pow(10, multipleOfTen);
            multipleOfTen--;
        }

        return number;
    }

    private boolean isPrimeNumber(int number) {
        if (number < 2) return false;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
