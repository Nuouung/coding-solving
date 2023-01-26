package programmers;

public class StringInsideString {
    public int solution(String str1, String str2) {
        return str1.contains(str2) ? 1 : 2;
    }
}
