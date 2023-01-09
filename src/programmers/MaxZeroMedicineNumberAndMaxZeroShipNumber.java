package programmers;

public class MaxZeroMedicineNumberAndMaxZeroShipNumber {

    public int[] solution(int n, int m) {
        int big = Math.max(n, m);
        int small = Math.min(n, m);
        int gcd = gcd(big, small);
        return new int[]{gcd, (n * m) / gcd};
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }
}
