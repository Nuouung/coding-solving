package programmers;

import java.util.*;

public class CutAndStoreAsArray {
    public String[] solution(String my_str, int n) {
        List<String> myList = new ArrayList<>();

        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : my_str.toCharArray()) {
            sb.append(c);
            index++;

            if (index == n) {
                myList.add(sb.toString());
                sb = new StringBuilder();
                index = 0;
            }
        }

        if (!sb.toString().equals("")) {
            myList.add(sb.toString());
        }

        return myList.toArray(new String[0]);
    }
}
