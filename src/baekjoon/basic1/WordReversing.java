package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordReversing {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine();
        StringBuilder sb = new StringBuilder(sentence);

        boolean isInTag = false;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '<') {
                isInTag = true;
                continue;
            }

            if (sentence.charAt(i) == '>') {
                isInTag = false;
                continue;
            }

            if (!isInTag) {
                int startIndex = i;
                StringBuilder sb2 = new StringBuilder();
                while (i < sentence.length() && sentence.charAt(i) != ' ' && sentence.charAt(i) != '<') {
                    sb2.append(sentence.charAt(i));
                    i++;
                }

                sb2.reverse();
                sb.replace(startIndex, i, sb2.toString());
                if (i < sentence.length() && sentence.charAt(i) == '<') i--;
            }
        }

        System.out.println(sb);
    }
}
