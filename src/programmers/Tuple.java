package programmers;

import java.util.HashMap;
import java.util.Map;

public class Tuple {

    public static void main(String[] args) {
        Tuple t = new Tuple();
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        t.solution(s);
    }

    public int[] solution(String s) {
        Map<Integer, int[]> map = new HashMap<>(); // length, array

        String[] array1 = s.substring(1, s.length() - 2).split("},");
        for (String temp1 : array1) {
            String[] array2 = temp1.substring(1).split(",");
            int[] targetArray = new int[array2.length];
            for (int i = 0; i < array2.length; i++) {
                targetArray[i] = Integer.parseInt(array2[i]);
            }

            map.put(targetArray.length, targetArray);
        }

        // map에 key 1 ~ array1.length 만큼 데이터가 쌓임.
        int[] result = new int[array1.length];
        for (int i = 1; i <= array1.length; i++) {
            for (int value : map.get(i)) {
                boolean isExist = false;
                for (int in : result) {
                    if (value == in) {
                        isExist = true;
                        break;
                    }
                }

                if (!isExist) result[i - 1] = value;
            }
        }

        return result;
    }
}
