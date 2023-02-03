package programmers;

import java.util.*;

public class SnailTrail {

    public static void main(String[] args) {
        SnailTrail s = new SnailTrail();
        for (int n : s.solution(5)) {
            System.out.print(n + " ");
        }
    }

    int[][] snailTrail;
    boolean[][] visited;

    Map<Character, String> direction;
    Map<Character, int[]> border;

    int trail = 1;

    char currentDirection = 'D';
    int currentX = 0, currentY = 0;

    int directionX = 0, directionY = 1;

    public int[] solution(int n) {
        dataInit(n);
        markTrail();

        while(!visited[currentX + directionX][currentY + directionY]) {
            // 이동
            currentX = currentX + directionX;
            currentY = currentY + directionY;
            markTrail();

            // 경계에 도달했다면 방향과 진행 경로 정보를 바꿔줌
            if (reachBorder()) {
                lineNewBorder();
                rememberNewDirection();
            }
        }

        return getResult(n);
    }

    private int[] getResult(int n) {
        List<Integer> result = new ArrayList<>();
        int resultIndex = 0;
        for (int[] st : snailTrail) {
            for (int number : st) {
                if (number != 0) {
                    result.add(number);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void rememberNewDirection() {
        String[] directionInfo = direction.get(currentDirection).split(",");
        currentDirection = directionInfo[0].charAt(0);
        directionX = Integer.parseInt(directionInfo[1]);
        directionY = Integer.parseInt(directionInfo[2]);
    }

    private boolean reachBorder() {
        int currentBorder = border.get(currentDirection)[0] == 0 ? currentX : currentY;
        return border.get(currentDirection)[1] == currentBorder;
    }

    private void lineNewBorder() {
        int newBorder = border.get(currentDirection)[0] == 0 ? currentX - directionX : currentY - directionY;
        if (currentDirection == 'R') newBorder = newBorder - 1; // -1이 아니라 -2로 줄어드므로

        int[] targetBorder = border.get(currentDirection);
        targetBorder[1] = newBorder;
        border.put(currentDirection, targetBorder);
    }

    private void markTrail() {
        // 번호 기입하기
        snailTrail[currentY][currentX] = trail++;
        // 흔적 남기기
        visited[currentY][currentX] = true;
    }

    private void dataInit(int n) {
        snailTrail = new int[n][n];
        visited = new boolean[n][n];
        directionInit();
        borderInit(n);
    }

    private void borderInit(int n) {
        border = new HashMap<>();

        border.put('D', new int[]{1, n - 1}); // 인덱스 0번이 x,y의 여부를 가리킴. 값이 0이면 x, 값이 1이면 y
        border.put('R', new int[]{0, n - 1});
        border.put('U', new int[]{1, 1});
    }

    void directionInit() {
        direction = new HashMap<>();

        direction.put('U', "D,0,1"); // U -> D (진행 x = 0, y = 1)
        direction.put('D', "R,1,0"); // D -> R (진행 x = 1, y = 0)
        direction.put('R', "U,-1,-1"); // R -> U (진행 x = -1, y = -1)
    }
}
