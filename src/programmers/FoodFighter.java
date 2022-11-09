package programmers;

import java.util.Arrays;

public class FoodFighter {

    public static void main(String[] args) {
        FoodFighter f = new FoodFighter();
        String solution = f.solution(new int[]{1, 3, 4, 6});
        System.out.println(solution);
    }

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = food.length - 1; i > 0; i--) {
            int number = food[i] / 2;
            sb.append(String.valueOf(i)
                    .repeat(Math.max(0, number)));
        }

        String right = sb.toString();
        char[] charArray = right.toCharArray();
        Arrays.sort(charArray);
        StringBuilder left = new StringBuilder();
        for (char c : charArray) {
            left.append(c);
        }

        return left + "0" + right;
    }
}