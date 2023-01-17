package programmers;

import java.util.Stack;

public class RotateBracket {

    Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        RotateBracket rb = new RotateBracket();
        System.out.println(rb.solution("()("));
    }

    public int solution(String s) {

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            String rotatedString = s.substring(i) + s.substring(0, i);

            boolean valid = true;

            for (char c : rotatedString.toCharArray()) {
                // { = 123, } = 125, [ = 91, ] = 93, ( = 40, ) = 41
                if (isOpenBracket(c)) {
                    stack.push(c);
                    continue;
                }

                if (stack.isEmpty()) {
                    valid = false;
                    break;
                }

                char openBracket = stack.pop();
                if (!isPairBracket(c, openBracket)) {
                    valid = false;
                    break;
                }
            }

            if (valid && stack.isEmpty()) result++;
        }

        return result;
    }

    private boolean isPairBracket(char c, Character openBracket) {
        return c == openBracket + 2 || c == openBracket + 1;
    }

    private boolean isOpenBracket(char c) {
        return c == 123 || c == 91 || c == 40;
    }
}
