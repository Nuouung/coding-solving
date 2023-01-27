package programmers;

public class SplitString {

    public static void main(String[] args) {
        SplitString s = new SplitString();
        System.out.println(s.solution("aaabbaccccabba"));
    }

    public int solution(String s) {
        int result = 0;
        int a = 0;
        int b = 0;
        char current = 0;
        boolean isNew = true;

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                result++;
                break;
            }

            if (isNew) {
                current = s.charAt(i);
                isNew = false;
                a++;
                continue;
            }

            if (s.charAt(i) == current) a++;
            if (s.charAt(i) != current) b++;

            if (a == b) {
                result++;
                a = 0;
                b = 0;
                current = 0;
                isNew = true;
            }
        }

        return result;
    }
}
