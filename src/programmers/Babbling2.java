package programmers;

public class Babbling2 {

    public int solution(String[] babbling) {
        int result = 0;
        for (String value : babbling) {
            StringBuilder babble = new StringBuilder(value);

            String lastWord = "";
            while (babble.length() > 1) {
                boolean check = false;

                String two = babble.substring(0, 2);
                if (two.equals("ye") || two.equals("ma")) {
                    if (!two.equals(lastWord)) {
                        babble.replace(0, 2, "");
                        lastWord = two;
                        check = true;
                    }

                } else if (babble.length() > 2) {
                    String three = babble.substring(0, 3);
                    if (three.equals("aya") || three.equals("woo")) {
                        if (!three.equals(lastWord)) {
                            babble.replace(0, 3, "");
                            lastWord = three;
                            check = true;
                        }
                    }
                }

                if (!check) break;
            }

            if (babble.length() == 0) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Babbling2 b = new Babbling2();
        System.out.println(b.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
}
