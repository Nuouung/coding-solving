package programmers;

public class JaritsuDeohagi {

    public static void main(String[] args) {
        JaritsuDeohagi j = new JaritsuDeohagi();
        System.out.println(j.solution(1234));
    }

    public int solution(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n = n / 10;
        }

        return result;
    }
}
