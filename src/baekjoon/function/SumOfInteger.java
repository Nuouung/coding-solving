package baekjoon.function;

public class SumOfInteger {

    long sum(int[] a) {
        long answer = 0;
        for (int i : a) {
            answer += i;
        }
        return answer;
    }

}
