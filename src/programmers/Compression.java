package programmers;

import java.util.*;

public class Compression {

    Map<String, Integer> dictionary = new HashMap<>();
    int index = 1;

    public static void main(String[] args) {
        Compression c = new Compression();
        c.solution("TOBEORNOTTOBEORTOBEORNOT");
    }

    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();

        dictionaryInit();

        for (int i = 0; i < msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
            int number = 1;

            // 추가할 다음 문자열 획득
            sb.append(msg.charAt(i));
            while (dictionary.get(sb.toString()) != null) {
                number++;
                i++;
                if (i == msg.length()) {
                    break;
                }

                sb.append(msg.charAt(i));
            }

            // 없는 문자열을 사전에 등록
            if (dictionary.get(sb.toString()) == null) {
                dictionary.put(sb.toString(), index);
            }
            i--;
            index++;

            String targetString = msg.substring(i - number + 2, i + 1);
            list.add(dictionary.get(targetString));
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private void dictionaryInit() {
        String initString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < initString.length(); i++) {
            dictionary.put(String.valueOf(initString.charAt(i)), index);
            index++;
        }
    }
}
