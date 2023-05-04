package baekjun.basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RemoteController {

    static Map<Integer, Boolean> brokenKeyMap = new HashMap<>();
    static int targetNumber;
    static long min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) brokenKeyMap.put(i, false);

        targetNumber = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        if (n > 0) {
            String[] temp = br.readLine().split(" ");
            for (String s : temp) brokenKeyMap.put(Integer.parseInt(s), true);
        }

        // 1. 100에서 targetNumber까지
        min = Math.abs(targetNumber - 100);

        // 2. 0부터 하나하나 전진하며 최소값을 갱신
        for (int i = 0; i <= 999_999; i++) {
            String s = String.valueOf(i);
            boolean hasBrokenKey = false;
            for (char c : s.toCharArray()) {
                if (brokenKeyMap.get(Character.getNumericValue(c))) {
                    hasBrokenKey = true;
                    break;
                }
            }

            if (!hasBrokenKey) {
                int current = String.valueOf(i).length(); // 숫자를 입력하는 거 (2345면 4)
                current = current + Math.abs(targetNumber - i);

                min = Math.min(min, current);
            }
        }

        System.out.println(min);
    }
}
