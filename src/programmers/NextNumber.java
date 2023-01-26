package programmers;

public class NextNumber {

    public int solution(int[] common) {
        int a1 = common[0];
        int a2 = common[1];
        int a3 = common[2];

        int n = common.length;

        int b1 = a2 - a1;
        int b2 = a3 - a2;
        if (b1 == b2) { // 등차수열
            return n * b1 + a1;
        }

        // 등비수열
        int b = a2 / a1;
        return a1 * (int) Math.pow(b, n);
    }
}
