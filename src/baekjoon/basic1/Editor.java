package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Editor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int cursor = sb.length();
        // abc length = 3 cursor = 3

        while (N-- > 0) {
            String command = br.readLine();

            switch (command) {
                case "L":
                    cursor -= 1;
                    if (cursor < 0) cursor = 0;
                    break;
                case "D":
                    cursor += 1;
                    if (cursor > sb.length()) cursor = sb.length();
                    break;
                case "B":
                    if (cursor != 0) {
                        sb.delete(cursor - 1, cursor);
                        cursor -= 1;
                    }
                    break;
                default:
                    String insertKey = command.split(" ")[1];
                    sb.insert(cursor, insertKey);
                    cursor++;
                    break;
            }
        }

        System.out.println(sb);
    }
}
