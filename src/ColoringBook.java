public class ColoringBook {

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] pictures = picture;
        // (0,0) 노드에서 시작해 (m-1, n-1)까지 순회하는 .. 즉 m * n 만큼의 루프가 필요
        // 매번 순회시 기록해야 하는 것.
        //  1) 현재 노드가 속한 색의 면적이 얼마인지 -> maxSizeOfOneArea를 구하기 위함
        //  2) 지금까지 몇 개의 면적이 있었는지.

        int[][] isThisNodeChecked = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                // m * n 바퀴 도는 루프
                // 이 루프에서는 모든 노드가 한번씩 호출됨
                // 현재 노드 = (i, j)
                int currentNode = pictures[i][j];

                // 현재 노드값이 0이 아닌 경우
                if (currentNode != 0) {

                    // 우선 이 노드가 checked 되어 있는지 확인
                    // 1인 경우 checked, 0인 경우 unchecked
                    if (isThisNodeChecked[i][j] != 1) {
                        isThisNodeChecked[i][j] = 1; // check 표시
                        numberOfArea++; // numberOfArea를 하나 올린다.

                        int i1 = i + 1;
                        int i2 = j;
                        int sizeOfCurrentArea = 1;
                        while (i2 < n) {
                            if (i1 == i && pictures[i1][i2] != currentNode) {
                                break;
                            }

                            if (i1 < m) {
                                if (pictures[i1][i2] == currentNode) {
                                    isThisNodeChecked[i1][i2] = 1; // check 표시
                                    sizeOfCurrentArea++;
                                    i1++; // i1 한칸 전진
                                } else {
                                    i1 = i;
                                    i2 ++; // 노드를 순회하다 다른 색을 만나면 m의 값을 되돌리고 n의 값을 한칸 전진한다.
                                }
                            } else {
                                break;
                            }

                        }
                        if (sizeOfCurrentArea > maxSizeOfOneArea) {
                            maxSizeOfOneArea = sizeOfCurrentArea;
                        }
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
