package baekjoon.recursion;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Hanoi {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        bw.write((int) (Math.pow(2, n) - 1) + "\n");
        hanoi(n, 1, 3, 2);
        bw.flush();
        bw.close();

    }

    // 재귀함수는 선언적 프로그래밍
    // 종료조건과 수행 방법을 명시하는 것에 집중
    public static void hanoi(int n, int from, int to, int other) throws IOException {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, other, to); // 마지막 돌을 제외한 나머지 돌을 움직인다.
        bw.write(from + " " + to + "\n"); // 돌의 움직임을 출력
        hanoi(n - 1, other, to, from); // 나머지 돌을 마지막 돌 위에 올린다.
    }

}
