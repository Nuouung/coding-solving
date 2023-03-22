package programmers;

public class BunchOfCard {

    public static void main(String[] args) {
        BunchOfCard b = new BunchOfCard();
        System.out.println(b.solution(new String[]{"i", "water", "drink"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}));
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;

        for (String s : goal) {
            if (index1 < cards1.length && s.equals(cards1[index1])) {
                index1++;
                continue;
            }

            if (index2 < cards2.length && s.equals(cards2[index2])) {
                index2++;
                continue;
            }

            return "NO";
        }

        return "YES";
    }
}
