package programmers;

public class SecretBetweenTwo {

    public static void main(String[] args) {
        SecretBetweenTwo s = new SecretBetweenTwo();
        System.out.println(s.solution("z", "abcdefghij", 20));
    }

    char[] alphabets;
    int[] results;

    public String solution(String s, String skip, int index) {
        alphabets = new char[26 - skip.length()];
        results = new int[s.length()];

        int alphabetsIndex = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (skip.indexOf((char) i) == -1) {
                alphabets[alphabetsIndex] = (char) i;
                alphabetsIndex++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < alphabets.length; j++) {
                if (s.charAt(i) == alphabets[j]) {
                    results[i] = j + index;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int result : results) {
            while (result >= alphabets.length) {
                result = result - alphabets.length;
            }

            sb.append(alphabets[result]);
        }

        return sb.toString();
    }
}
