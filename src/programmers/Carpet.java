package programmers;

public class Carpet {

    public static void main(String[] args) {
        Carpet c = new Carpet();
        c.solution(24, 24);
    }

    public int[] solution(int brown, int yellow) {
        if ((brown - 4) % 2 != 0) {
            throw new RuntimeException("Bad approach");
        }

        int border = (brown - 4) / 2;

        int x, y;
        x = (int) (border + Math.sqrt(Math.pow(border, 2) - 4 * yellow)) / 2;
        y = border - x;

        return new int[]{x + 2, y + 2};
    }
}
