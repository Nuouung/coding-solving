package programmers;

public class NumberOfSeven {

    public static void main(String[] args) {
        NumberOfSeven n = new NumberOfSeven();
        n.solution(new int[]{7, 77, 17});
    }

    public int solution(int[] array) {
        int count = 0;
        for (int n : array) {
            String number = Integer.toString(n);

            for (char c : number.toCharArray()) {
                if (c == 55) { // 7 == 55
                    count++;
                }
            }
        }

        return count;
    }
}
