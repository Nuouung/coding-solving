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

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[][] arrayXAndY = new int[N][2];

        for (int i = 0; i < N; i++) {
            arrayXAndY[i][0] = in.nextInt();
            arrayXAndY[i][1] = in.nextInt();
        }

        Arrays.sort(arrayXAndY, (valueA, valueB) -> {
            if (valueA[0] == valueB[0]) {
                return valueA[1] - valueB[1];
            } else {
                return valueA[0] - valueB[0];
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arrayXAndY[i][0] + " " + arrayXAndY[i][1]);
        }

    }

}
