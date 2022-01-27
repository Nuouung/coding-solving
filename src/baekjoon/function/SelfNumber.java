package baekjoon.function;

public class SelfNumber {

    public static void main(String[] args) {

        boolean[] singleNumberArray = new boolean[10001];

        for (int i = 1; i <= 10001; i++) {

            int n = d(i);
            if (n < 10001) {
                singleNumberArray[n] = true;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!singleNumberArray[i]) {
                System.out.println(i);
            }
        }
    }

    public static int d(int i) {
        int sum = i;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

}
