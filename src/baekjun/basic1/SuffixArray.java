package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuffixArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Map<Integer, List<Integer>> myMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (myMap.get(s.charAt(i) - 'a') == null) {
                bindDataToMap(s, myMap, i, new ArrayList<>());
                continue;
            }

            bindDataToMap(s, myMap, i, myMap.get(s.charAt(i) - 'a'));
        }

        for (int i = 0; i < 26; i++) {
            if (myMap.get(i) == null) continue;

            printData(s, myMap, i);
        }
    }

    private static void printData(String s, Map<Integer, List<Integer>> myMap, int i) {
        List<Integer> list = myMap.get(i);
        for (int j = list.size() - 1; j >= 0; j--) {
            System.out.println(s.substring(list.get(j)));
        }
    }

    private static void bindDataToMap(String s, Map<Integer, List<Integer>> myMap, int i, List<Integer> list) {
        list.add(i);
        myMap.put(s.charAt(i) - 'a', list);
    }
}
