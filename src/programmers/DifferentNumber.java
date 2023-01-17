package programmers;

import java.util.Arrays;

public class DifferentNumber {

    public static void main(String[] args) {
        DifferentNumber d = new DifferentNumber();
        System.out.println(Arrays.toString(d.solution(new long[]{2, 7})));
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            StringBuilder targetBinary = new StringBuilder(getBinary(numbers[i]));
            long current = numbers[i];
            while (true) {
                long next = current + 1;
                String nextBinary = getBinary(next);
                while (nextBinary.length() > targetBinary.length()) {
                    targetBinary.insert(0, "0");
                }

                int difference = 0;
                for (int j = 0; j < nextBinary.length(); j++) {

                    if (targetBinary.charAt(j) != nextBinary.charAt(j)) {
                        difference++;
                    }
                }

                if (difference < 3) {
                    answer[i] = next;
                    break;
                }

                current++;
            }
        }

        return answer;
    }

    private String getBinary(long number) {
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            sb.append(number % 2);
            number = number / 2;
        }

        return sb.reverse().toString();
    }
}
