package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenDwarf {

    static boolean[] visited = new boolean[9];
    static int[] dwarfs = new int[9];
    static int[] dwarfsJar = new int[7];

    static boolean isOver = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dwarfs);

        dfs(0, 0);
    }

    static void dfs(int start, int depth) {
        if (depth == 7) {
            if (!isOver) {
                int sum = 0;
                for (int dwarf : dwarfsJar) {
                    sum += dwarf;
                }

                if (sum == 100) {
                    isOver = true;

                    for (int dwarf : dwarfsJar) {
                        System.out.println(dwarf);
                    }
                }
            }

            return;
        }

        for (int i = start; i < dwarfs.length; i++) {
            visited[i] = true;
            dwarfsJar[depth] = dwarfs[i];

            dfs(start + 1, depth + 1);

            visited[i] = false;
            dwarfsJar[depth] = 0;
        }
    }
}
