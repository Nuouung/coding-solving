package programmers;

public class StringFragment {

    public static void main(String[] args) {
        StringFragment s = new StringFragment();
        System.out.println(s.solution("10003", "15"));
    }

    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            String fragment = t.substring(i, i + p.length());
            answer += Long.parseLong(fragment) <= Long.parseLong(p) ? 1 : 0;
        }

        return answer;
    }
}
