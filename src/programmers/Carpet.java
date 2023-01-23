package programmers;

public class Carpet {

    public static void main(String[] args) {
        Carpet c = new Carpet();
        c.solution(24, 24);
    }

    public int[] solution(int brown, int yellow) {
        int border = (brown + yellow) / 2 - 2;

        double positiveResult = (border + Math.sqrt(Math.pow(border, 2) - 4 * yellow)) / 2;
        double negativeResult = (border - Math.sqrt(Math.pow(border, 2) - 4 * yellow)) / 2;

        int x = 0;
        if (positiveResult == (int) positiveResult) { // 정수라는 뜻
            x = (int) positiveResult;
        } else if (negativeResult == (int) negativeResult) {
            x = (int) negativeResult;
        }


        int y = border - x;

//        int xMaxLength = (int) Math.sqrt(yellow);

        return new int[]{x, y};
    }
}
