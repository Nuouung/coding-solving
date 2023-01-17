package programmers;

import java.util.*;

public class Printer {

    Queue<List<Integer>> printer = new LinkedList<>();

    public static void main(String[] args) {
        Printer p = new Printer();
        System.out.println(p.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location) {
        int result = 1;

        dataInit(priorities, location);

        while (true) {
            // 1. 큐에서 하나를 꺼낸다.
            List<Integer> candidate = printer.poll();

            // 2. 프린터 대기목록을 순회하며 뽑은 값이 가장 높은 우선순위인지 확인한다.
            boolean isLargest = true;
            for (List<Integer> printerList : printer) {
                if (printerList.get(1) > candidate.get(1)) {
                    isLargest = false;
                    break;
                }
            }

            // 3. 가장 높은 값이면 출력하고 출력된 값이 location 값이면 result를 리턴한다.
            // 3. 아니면 가장 마지막에 값을 넣고 계속 돌린다.
            if (isLargest) {
                if (candidate.get(0) == 1) {
                    return result;
                } else {
                    result++;
                }
            } else {
                printer.add(candidate);
            }
        }
    }

    private void dataInit(int[] priorities, int location) {
        for (int i = 0; i < priorities.length; i++) {
            List<Integer> list = new ArrayList<>();
            int target = (i == location) ? 1 : 0;

            list.add(target);
            list.add(priorities[i]);

            printer.add(list);
        }
    }
}
