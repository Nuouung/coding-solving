package programmers;

public class MinimumSquare {

    int maxWidth = 0;
    int maxHeight = 0;

    public int solution(int[][] sizes) {
        // 카드를 가로 > 세로 순으로 눕힌다.
        // 가로에서 가장 큰 길이, 세로에서 가장 큰 길이를 곱한다.
        for (int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];

            if (a >= b) { // 직사각혐이므로 = 은 나오지 않음
                sizes[i][0] = a;
                sizes[i][1] = b;
            } else {
                sizes[i][0] = b;
                sizes[i][1] = a;
            }
        }

        for (int[] size : sizes) {
            if (size[0] > maxWidth) maxWidth = size[0];
            if (size[1] > maxHeight) maxHeight = size[1];
        }

        return maxWidth * maxHeight;
    }
}
