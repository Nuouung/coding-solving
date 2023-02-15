package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NumeralSystemConversion2 {

    static Map<Character, Integer> extraLetters = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setExtraLetters();

        String[] s = br.readLine().split(" ");
        System.out.println(solution(s[0], Integer.parseInt(s[1])));
    }

    static long solution(String target, int convertNumber) {
        target = new StringBuilder(target).reverse().toString();
        long result = 0;

        for (int i = 0; i < target.length(); i++) {
            result = result + getConvertedNumber(target.charAt(i), convertNumber, i);
        }

        return result;
    }

    static long getConvertedNumber(char target, int convertNumber, int multiplier) {
        if (extraLetters.get(target) == null) {
            return (long) (Character.getNumericValue(target) * Math.pow(convertNumber, multiplier));
        }

        return (long) (extraLetters.get(target) * Math.pow(convertNumber, multiplier));
    }

    static void setExtraLetters() {
        for (int i = 10; i < 36; i++) {
            int charName = i + 55; // i = 10 -> charName = 65 (A)
            extraLetters.put((char) charName, i);
        }
    }
}
