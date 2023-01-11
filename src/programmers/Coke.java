package programmers;

public class Coke {

    int emptyBottle;

    public int solution(int a, int b, int n) {
        emptyBottle = n;

        int answer = 0;
        while (emptyBottle >= a) {
            long newCoke = (emptyBottle / (long) a) * (long) b;
            emptyBottle = emptyBottle % a;

            answer += newCoke;
            emptyBottle += newCoke;
        }

        return answer;
    }

    public static void main(String[] args) {
        Coke coke = new Coke();
        System.out.println(coke.solution(3, 1, 20));
    }
}
