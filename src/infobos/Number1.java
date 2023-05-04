package infobos;

public class Number1 {

    public static void main(String[] args) {
        Number1 n = new Number1();
        System.out.println(n.solution(100_00_00, 3, 100_00_00));
    }

    public int solution(int p, int m, int d) {
        for (int i = 0; i <= 100; i++) {
            double temp = p;
            double k = (double) i / 100;

            for (int j = 0; j < m; j++)
                temp = Math.floor(temp * (1 + k)); // 소수점 버리고 계산

            if (temp >= d) return i;
        }

        return -1;
    }
}
