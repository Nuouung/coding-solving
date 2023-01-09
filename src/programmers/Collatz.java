package programmers;

public class Collatz {

    public static void main(String[] args) {
        Collatz c = new Collatz();
        System.out.println(c.solution(626331));
    }

    public int solution(int num) {
        if (num == 1) return 0;
        long number = num;

        int result = 0;
        while (number != 1 && result < 500) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = number * 3 + 1;
            }

            result++;
        }

        return result >= 500 ? -1 : result;
    }
}
