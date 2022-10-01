package baekjoon.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Josephus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append("<");

        String readLine = br.readLine();
        int N = Integer.parseInt(readLine.split(" ")[0]);
        int K = Integer.parseInt(readLine.split(" ")[1]);

        int[] circleArray = new int[N];
        for (int i = 0; i < N; i++) {
            circleArray[i] = i;
        }

        // 7 3
        // 0 = 7
        int dyingPoint = 0;
        int index = N;
        while (index-- > 0) {
            int count = K;
            while (count > 0) {
                dyingPoint++;
                if (dyingPoint >= N) {
                    dyingPoint = 0;
                }

                if (circleArray[dyingPoint] != -1) {
                    count--;
                }
            }

            int dyingNumber = circleArray[dyingPoint];
            circleArray[dyingPoint] = -1;

            if (index == 0) {
                sb.append(dyingNumber == 0 ? N : dyingNumber).append(">");
            } else {
                sb.append(dyingNumber == 0 ? N : dyingNumber).append(", ");
            }
        }

        System.out.println(sb);
    }
}
