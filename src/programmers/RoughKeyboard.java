package programmers;

import java.util.Arrays;

public class RoughKeyboard {

    int[] alphabet = new int[26];

    public static void main(String[] args) {
        RoughKeyboard r = new RoughKeyboard();
        int[] solution = r.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"});

        for (int i : solution) {
            System.out.println(i);
        }
    }

    public int[] solution(String[] keymap, String[] targets) {
        Arrays.fill(alphabet, Integer.MAX_VALUE);

        setAlphabet(keymap);

        int[] result = new int[targets.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = getResult(targets[i]);
        }

        return result;
    }

    private int getResult(String target) {
        int sum = 0;

        for (int i = 0; i < target.length(); i++) {
            if (alphabet[target.charAt(i) - 65] == Integer.MAX_VALUE) return -1;

            sum = sum + alphabet[target.charAt(i) - 65];
        }

        return sum;
    }

    private void setAlphabet(String[] keymap) {
        for (String s : keymap) {
            for (int j = 0; j < s.length(); j++) {
                alphabet[s.charAt(j) - 65] =
                        Math.min(alphabet[s.charAt(j) - 65], j + 1);
            }
        }
    }
}
