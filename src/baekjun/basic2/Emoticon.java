package baekjun.basic2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Emoticon {

    static int SCREEN = 0;
    static int CLIPBOARD = 1;

    static int[][] minMap;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();

        minMap = new int[target + 2][target + 2]; // 화면과 클립보드의 이모티콘 수의 최소 경우의 수
        visited = new boolean[target + 2][target + 2];

        // 초기화면은 화면에 이모티콘이 하나 있고 클립보드가 비어 있는 화면
        // 행이 화면, 열이 클립보드다. [0][1] = 화면 0, 클립보드 1
        visited[1][0] = true;
        minMap[1][0] = 0;

        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{1, 0});

        while (!queue.isEmpty()) {
            Integer[] node = queue.poll();

            if (node[SCREEN] == target) {
                System.out.println(minMap[node[SCREEN]][node[CLIPBOARD]]);
                System.exit(0);
            }

            // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if (!visited[node[SCREEN]][node[SCREEN]]) {
                visited[node[SCREEN]][node[SCREEN]] = true;
                minMap[node[SCREEN]][node[SCREEN]] = minMap[node[SCREEN]][node[CLIPBOARD]] + 1;
                queue.offer(new Integer[]{node[SCREEN], node[SCREEN]});
            }

            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            int screenPlusClipboard = node[SCREEN] + node[CLIPBOARD];
            if (screenPlusClipboard <= target + 1) {
                if (!visited[screenPlusClipboard][node[CLIPBOARD]]) {
                    visited[screenPlusClipboard][node[CLIPBOARD]] = true;
                    minMap[screenPlusClipboard][node[CLIPBOARD]] = minMap[node[SCREEN]][node[CLIPBOARD]] + 1;
                    queue.offer(new Integer[]{screenPlusClipboard, node[CLIPBOARD]});
                }
            }

            // 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (node[SCREEN] > 0) {
                int screenMinusOne = node[SCREEN] - 1;
                if (!visited[screenMinusOne][node[CLIPBOARD]]) {
                    visited[screenMinusOne][node[CLIPBOARD]] = true;
                    minMap[screenMinusOne][node[CLIPBOARD]] = minMap[node[SCREEN]][node[CLIPBOARD]] + 1;
                    queue.offer(new Integer[]{screenMinusOne, node[CLIPBOARD]});
                }
            }
        }
    }
}
