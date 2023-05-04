package infobos;

import java.util.*;

public class Number2 {

    Map<Integer, Boolean> waitingMap = new HashMap<>();

    public static void main(String[] args) {
        Number2 n = new Number2();
        int[] r = n.solution(new int[]{1,5,8,2,10,5,4,6,4,8});
        for (int i : r) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[] waiting) {
        List<Integer> newList = new ArrayList<>();

        for (int client : waiting) {
            if (waitingMap.get(client) != null) continue; // 이미 웨이팅 배열에 속해 있던 요소라면 패스

            waitingMap.put(client, true); // 웨이팅 배열에 들어 있는 요소임을 체크
            newList.add(client);
        }

        return newList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
