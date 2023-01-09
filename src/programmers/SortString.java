package programmers;

public class SortString {

    public String solution(String my_string) {
        String lowerCaseString = toLowerCase(my_string);
        return sort(lowerCaseString);
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

    private String sort(String target) {
        // bacd
        StringBuilder sb = new StringBuilder();
        char previousChar = 10000;
        int targetIndex = 0;

        for (int i = 0; i < target.length(); i++) {

            for (int j = 0; j < target.length(); j++) {
                if (target.charAt(j) < previousChar) {
                    previousChar = target.charAt(j);
                    targetIndex = j;
                }
            }

            sb.append(target.charAt(targetIndex));
            target = target.substring(0, targetIndex) +  ((char) 10000) + target.substring(targetIndex + 1);
            previousChar = 10000;
        }

        return sb.toString();
    }

}
