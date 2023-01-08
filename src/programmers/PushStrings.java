package programmers;

public class PushStrings {

    public static void main(String[] args) {
        PushStrings p = new PushStrings();
        System.out.println(p.solution("apple", "apple"));
    }

    public int solution(String A, String B) {
        int count = 0;

        while (count < A.length()) {
            if (A.equals(B)) {
                break;
            }

            A = A.charAt(A.length() -1) + A.substring(0, A.length() - 1);
            count++;
        }

        return count != A.length() ? count : -1;
    }
}
