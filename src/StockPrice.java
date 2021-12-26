public class StockPrice {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[i] > prices[j]) {
                    answer[i] = count;
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        StockPrice sp = new StockPrice();
        for (int a : sp.solution(prices)) {
            System.out.println(a);
        }
    }

}
