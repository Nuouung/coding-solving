package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenDwarf {

    static int[] dwarfs = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++)
            dwarfs[i] = Integer.parseInt(br.readLine());

        Arrays.sort(dwarfs);
        calculate();

        for (int dwarf : dwarfs)
            if (dwarf != -1)
                System.out.println(dwarf);

    }

    private static void calculate() {
        int sum = Arrays.stream(dwarfs).sum();
        for (int i = 0; i < dwarfs.length; i++) {
            for (int j = 0; j < dwarfs.length; j++) {
                if (dwarfs[i] + dwarfs[j] == sum - 100) {
                    dwarfs[i] = dwarfs[j] = -1;
                    return;
                }
            }
        }
    }

}
