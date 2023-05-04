package flyingDoctor;

import java.util.HashMap;
import java.util.Map;

public class Number1 {

    Map<Integer, Integer> previous = new HashMap<>();
    Map<Integer, Integer> duplicated = new HashMap<>();

    public int solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (previous.get(arr[i]) == null) {
                // 처음 시작된 번호
                previous.put(arr[i], i);
                continue;
            }

            // set duplicated
            if (duplicated.get(arr[i]) == null) {
                // 처음 중복이 발견된 번호
                duplicated.put(arr[i], i - previous.get(arr[i]));
                continue;
            } else {
                // 중복이 이전에 이미 발견된 번호
                int duplicatedMinLength = Math.min(i - previous.get(arr[i]), duplicated.get(arr[i]));
                duplicated.put(arr[i], duplicatedMinLength);
            }

            // previous 최신화
            previous.put(arr[i], i);
        }

        if (duplicated.isEmpty()) return -1;

        int min = Integer.MAX_VALUE;
        for (Integer value : duplicated.values()) {
            min = Math.min(value, min);
        }

        return min;
    }
}
