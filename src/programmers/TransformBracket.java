package programmers;

import java.util.Stack;

public class TransformBracket {

    public static void main(String[] args) {
        TransformBracket t = new TransformBracket();
        System.out.println(t.solution("()))((()"));
    }

    public String solution(String p) {
        if (p.length() == 0) return "";

        int border = getUVBorder(p);
        String u = p.substring(0, border);
        String v = p.substring(border);

        if (isValidBracket(u)) {
            return u + solution(v);
        }

        return "(" + solution(v) + ")" + transformBrackets(u);
    }

    String transformBrackets(String u) {
        StringBuilder sb = new StringBuilder();

        String substring = u.substring(1, u.length() - 1);
        for (int i = 0; i < substring.length(); i++) {
            if (isOpenBracket(substring, i)) sb.append(")");
            else sb.append("(");
        }

        return sb.toString();
    }

    boolean isValidBracket(String u) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < u.length(); i++) {
            if (isOpenBracket(u, i)) {
                stack.add(u.charAt(i));
                continue;
            }

            if (stack.isEmpty()) return false;
            stack.pop();
        }

        return true;
    }

    int getUVBorder(String p) {
        int openBracket = 0;
        int closeBracket = 0;

        for (int i = 0; i < p.length(); i++) {
            if (isOpenBracket(p, i)) openBracket++;
            else closeBracket++;

            if (openBracket == closeBracket) {
                return i + 1;
            }
        }

        return -1;
    }

    private boolean isOpenBracket(String s, int i) {
        return s.charAt(i) == '(';
    }
}
