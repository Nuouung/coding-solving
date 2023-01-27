package epart;

/**
 *영어 대문자로 이루어진 문자열이 입력으로 주어집니다.
 *같은 문자가 연속이 되면 해당구간을'반복횟수+문자'로 교체한 새로운 문자열을 생성해주세요.
 *
 */
/**
 *예시
 *입력: ABBBCC /출력: A3B2C
 *입력: ABABAAB /출력: ABAB2AB
 */
public class PrintOut {

    public static void main(String[] args) {
        System.out.println(solution("ABABAAB"));
    }

    public static String solution(String input) {

        StringBuilder sb = new StringBuilder();

        char current = input.charAt(0);
        int startIndex = 0;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != current) {
                appendNewString(sb, i - startIndex, current);

                startIndex = i;
                current = input.charAt(i);
            }

            if (i == input.length() - 1) {
                appendNewString(sb, i + 1 - startIndex, current);
            }
        }

        return sb.toString();
    }

    static void appendNewString(StringBuilder sb, int distance, char current) {
        sb.append((distance == 1) ? String.valueOf(current) : distance + String.valueOf(current));
    }
}
