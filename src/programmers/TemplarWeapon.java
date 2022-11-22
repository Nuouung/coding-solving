package programmers;

public class TemplarWeapon {

    public static void main(String[] args) {
        TemplarWeapon t = new TemplarWeapon();
        System.out.println(t.solution(5, 3, 2));
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int divisor = getDivisorNumber(i);
            if (divisor > limit) {
                divisor = power;
            }

            answer += divisor;
        }

        return answer;
    }

    private int getDivisorNumber(int target) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(target); i++) {
            if (target % i == 0) {
                if (i != Math.sqrt(target)) {
                    count++;
                }

                count++;
            }
        }

        return count;
    }
}
