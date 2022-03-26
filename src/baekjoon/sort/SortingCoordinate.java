package baekjoon.sort;

import java.util.*;

public class SortingCoordinate {

    public static void main(String[] args) {
        // 1. x 좌표가 낮은 값 먼저 보냄
        // 2. x 좌표가 같은 값이 있으면 y 값을 비교

        // 아이디어.
        // 1. x 값을 array로 만들어 sort.
        // 2. x 값이 작은 순서대로 출력
        // 3. x 값이 같으면 arrayList에 같은 값을 넣는다.
        // 4. arrayList에 있는 값들을 y 값을 기준으로 비교
        // 5. 출력
        // 6. 계속 진행

        // 준비물
        // 1. key와 (x,y) value를 가진 Map<Integer, List<Integer>)
        // 2. x값 비교를 위한 int[]
        // 3. y값 비교를 위한 List<Integer>

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Map<Integer, List<Integer>> valueMap = new HashMap<>();
        int[] arrayForX = new int[N];
        List<Integer> listForY = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            List<Integer> tempList = new ArrayList<>();
            int x = in.nextInt();
            tempList.add(x);
            tempList.add(in.nextInt());
            valueMap.put(x, tempList);

            arrayForX[i] = x;
        }

        Arrays.sort(arrayForX);

        for (Integer integer : listForY) {

        }

    }

}
