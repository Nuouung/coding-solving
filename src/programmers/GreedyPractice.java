package programmers;

public class GreedyPractice {

    public static void main(String[] args) {
        GreedyPractice g = new GreedyPractice();
        System.out.println(g.greedy_getCoinMinSize(5000, 4040));
    }

    private int greedy_getCoinMinSize(int total, int offer) {
        int[] coins = {500, 100, 50, 10};

        int change = total - offer;
        System.out.println("최초 잔액 = " + change + "원");

        int result = 0;
        for (int coin : coins) {
            while (change - coin >= 0) {
                result++;
                change = change - coin;
                System.out.println(coin + "원 거슬러 줌. 잔액 = " + change);
            }

            if (change == 0) break;
        }

        return result;
    }
}
