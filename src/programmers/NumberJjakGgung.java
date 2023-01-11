package programmers;

public class NumberJjakGgung {

    public static void main(String[] args) {
        NumberJjakGgung s = new NumberJjakGgung();
        System.out.println(s.solution("100", "2345"));
    }

    public String solution(String X, String Y) {
        // 0 1 2 3 4 5 6 7 8 9
        int[] xArray = new int[10];
        for (char c : X.toCharArray()) { // 숫자는 -48 해야 함
            xArray[c - 48]++;
        }

        int[] finalArray = new int[10];
        for (char c : Y.toCharArray()) {
            if (xArray[c - 48] > 0) {
                finalArray[c - 48]++;
                xArray[c - 48]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (finalArray[i] > 0) {
                sb.append(i);
                finalArray[i]--;
            }
        }

        if (sb.toString().equals("")) sb = new StringBuilder("-1");
        if (sb.substring(0, 1).equals("0")) sb = new StringBuilder("0");

        return sb.toString();
    }
}
