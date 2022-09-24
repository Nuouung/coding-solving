package baekjoon.basic1;

import java.io.*;

public class BracketValidation {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {

            String nextLine = br.readLine() + "\n";
            StringBuilder sb = new StringBuilder(nextLine.substring(0, nextLine.length() - 1));

            boolean check = true;
            while (sb.length() > 0) {
                // 가장 왼쪽 ) 를 찾는다.
                int firstCloseBracket = sb.indexOf(")");
                if (firstCloseBracket <= 0 || sb.charAt(firstCloseBracket - 1) != '(') {
                    bw.write("NO");
                    bw.write("\n");
                    check = false;
                    break;
                } else {
                    sb.delete(firstCloseBracket - 1, firstCloseBracket + 1);
                }
            }

            if (check) {
                bw.write("YES");
                bw.write("\n");
            }
        }

        bw.flush();
    }
}
