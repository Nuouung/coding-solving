package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).matches("[a-zA-Z]")) {
                char c = transformLetter(s.charAt(i));
                sb.append(c);
                continue;
            }

            sb.append(s.charAt(i));
        }

        System.out.println(sb);
    }

    private static char transformLetter(char target) {
        if (String.valueOf(target).matches("[a-z]")) {
            return (char) (target + 13) > 'z' ? (char) (target + 13 - ('z' - 'a' + 1)) : (char) (target + 13);
        }

        return (char) (target + 13) > 'Z' ? (char) (target + 13 - ('Z' - 'A' + 1)) : (char) (target + 13);
    }
}
