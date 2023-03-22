package programmers;

public class SumOfConsecutivePulseSubsequences {

    long[][] dp;

    public static void main(String[] args) {
        SumOfConsecutivePulseSubsequences s = new SumOfConsecutivePulseSubsequences();

        System.out.println(s.solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4}));
    }

    public long solution(int[] sequence) {
        dp = new long[sequence.length][4];

        dp[0][0] = sequence[0] * -1;
        dp[0][1] = sequence[0];
        dp[0][2] = sequence[0] * -1;
        dp[0][3] = sequence[0];

        for (int i = 1; i < sequence.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][3]) + sequence[i] * -1;
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + sequence[i];
            dp[i][2] = sequence[i] * -1;
            dp[i][3] = sequence[i];
        }

        long result = 0;
        for (int i = 0; i < sequence.length; i++) {
            result = Math.max(result,
                    Math.max(dp[i][0],
                            Math.max(dp[i][1],
                                    Math.max(dp[i][2], dp[i][3]))));
        }

        return result;
    }
}
