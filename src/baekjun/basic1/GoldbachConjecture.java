package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachConjecture {

    static boolean[] composites;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String temp;
        composites = sieve();
        while (!(temp = br.readLine()).equals("0")) {
            int target = Integer.parseInt(temp);

            int[] goldbach = goldbachConjecture(target);
            if (errorOccur(goldbach)) {
                sb.append("Goldbach's conjecture is wrong.");
                continue;
            }

            sb.append(target).append(" = ")
                            .append(goldbach[0]).append(" + ")
                            .append(goldbach[1]).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean errorOccur(int[] goldbach) {
        return goldbach[0] == -1 && goldbach[1] == -1;
    }

    static int[] goldbachConjecture(int target) {
        for (int i = 2; i <= target / 2; i++) {
            // 두 값이 모두 소수인데 값의 합이 target과 같다면
            if (isPrime(i) && isPrime(target - i)) {
                return new int[]{i, target - i};
            }
        }
        
        return new int[]{-1, -1};
    }

    private static boolean isPrime(int value) {
        return !composites[value];
    }

    static boolean[] sieve() {
        boolean[] composites = new boolean[1_000_001]; // 0 ~ 1,000,000
        composites[0] = true;
        composites[1] = true;

        for (int i = 2; i < composites.length; i++) {
            if (!composites[i]) {
                int temp = i + i;
                while (temp <= composites.length - 1) {
                    composites[temp] = true;
                    temp = temp + i;
                }
            }
        }

        return composites;
    }
}
