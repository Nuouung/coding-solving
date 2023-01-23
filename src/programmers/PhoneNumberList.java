package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class PhoneNumberList {

    public static void main(String[] args) {
        PhoneNumberList p = new PhoneNumberList();
        System.out.println(p.solution(new String[]{"12", "123", "1235", "567", "88"}));
    }

    public boolean solution(String[] phonebook) {
        HashMap<String, Integer> myMap = new HashMap<>();
        for (String s : phonebook) {
            myMap.put(s, 1);
        }

        for (String s : phonebook) {
            for (int i = 0; i < s.length(); i++) {
                if (myMap.get(s.substring(0, i)) != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
