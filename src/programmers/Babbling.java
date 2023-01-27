package programmers;

public class Babbling {

    public static void main(String[] args) {
        Babbling b = new Babbling();
        System.out.println(b.solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}));
    }

    public int solution(String[] babbling) {
        String[] valid = {"aya", "woo", "ye", "ma"};

        int result = 0;

        for (String s : babbling) {
            for (String v : valid) {
                s = s.replace(v, "*");
            }

            if (s.replace("*", "").length() == 0) {
                result++;
            }
        }

        return result;
    }
}
