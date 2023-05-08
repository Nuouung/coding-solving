package baekjun.format;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Format1 {

    // 3 4
    // aaaa
    // bbbb
    // cccc

    static int width;
    static int height;

    static String[][] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();

        width = Integer.parseInt(s1.split(" ")[1]);
        height = Integer.parseInt(s1.split(" ")[0]);

        array = new String[height][width];
        for (int i = 0; i < height; i++) {
            String s2 = br.readLine();

            for (int j = 0; j < width; j++) {
                array[i][j] = String.valueOf(s2.charAt(j));
            }
        }
    }
}
