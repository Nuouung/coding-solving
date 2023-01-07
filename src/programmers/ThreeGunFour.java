package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThreeGunFour {

    int[] storageArray = new int[3];
    int storageArrayIndex = 0;
    boolean[] checkArray;
    int result = 0;

    public int solution(int[] number) {
        checkArray = new boolean[number.length];
        backtracking(number, 0);
        return result / 6;
    }

    private void backtracking(int[] number, int depth) {
        if (depth == 3) {
            result += storageArray[0] + storageArray[1] + storageArray[2] == 0 ? 1 : 0;
            return;
        }

        for (int i = 0; i < number.length; i++) {
            if (checkArray[i]) continue;

            checkArray[i] = true;
            storageArray[storageArrayIndex++] = number[i];

            backtracking(number, depth + 1);

            checkArray[i] = false;
            storageArray[--storageArrayIndex] = 0;
        }
    }
}
