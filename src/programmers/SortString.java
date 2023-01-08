package programmers;

public class SortString {

    public static void main(String[] args) {
        String a = "Bcad";
        SortString ss = new SortString();
        ss.solution(a);

    }

    public String solution(String my_string) {
        String lowerCaseString = toLowerCase(my_string);
        sort(lowerCaseString);
        return null;
    }

    private String toLowerCase(String target) {
        StringBuilder sb = new StringBuilder();

        for (char c : target.toCharArray()) {
            char targetChar = (65 <= c && c <= 90) ? // 대문자라면
                    (char) (c + 32) : c;

            sb.append(targetChar);
        }

        return sb.toString();
    }

    private void sort(String target) {
        // bacd
        StringBuilder sb = new StringBuilder();
        char previousChar = 0;
        char targetChar = 0;

        for (int i = 0; i < target.length(); i++) {

            for (char c : target.toCharArray()) {
                if (c < previousChar) {
                    previousChar = c;
                    targetChar = c;
                }
            }

            sb.append(targetChar);
        }
    }
}
