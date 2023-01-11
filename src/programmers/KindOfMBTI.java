package programmers;

import java.util.HashMap;
import java.util.Map;

public class KindOfMBTI {

    public static void main(String[] args) {
        KindOfMBTI k = new KindOfMBTI();
        System.out.println(k.solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }

    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> myMap = getMyMap();

        for (int i = 0; i < survey.length; i++) {
            int point = choices[i];
            char right = survey[i].charAt(1);
            char left = survey[i].charAt(0);

            if (point > 4) {
                myMap.put(right, myMap.get(right) + (point - 4));
            } else if (point < 4) {
                myMap.put(left, myMap.get(left) + (4 - point));
            }
        }

        String resultA = myMap.get('R') >= myMap.get('T') ? "R" : "T";
        String resultB = myMap.get('C') >= myMap.get('F') ? "C" : "F";
        String resultC = myMap.get('J') >= myMap.get('M') ? "J" : "M";
        String resultD = myMap.get('A') >= myMap.get('N') ? "A" : "N";

        return resultA + resultB + resultC + resultD;
    }

    private Map<Character, Integer> getMyMap() {
        Map<Character, Integer> myMap = new HashMap<>();
        myMap.put('R', 0);
        myMap.put('T', 0);
        myMap.put('C', 0);
        myMap.put('F', 0);
        myMap.put('J', 0);
        myMap.put('M', 0);
        myMap.put('A', 0);
        myMap.put('N', 0);

        return myMap;
    }
}
