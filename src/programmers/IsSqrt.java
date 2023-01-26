package programmers;

public class IsSqrt {
    public int solution(int n) {
        double sqrt = Math.sqrt(n);
        return (sqrt % 1 == 0) ? 1 : 2;
    }
}
