package baekjoon.basic1;

import java.util.logging.Logger;

public class PrintSpeedTest {

    private static final Logger log = Logger.getGlobal();

    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        int[] array = new int[10000000]; // 천만건

        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;

        long t2 = System.currentTimeMillis();
        log.info("배열 생성 및 초기화 시간: " + (t2 - t1) + "ms");

        long t3 = System.currentTimeMillis();
        for (int i : array) {
            System.out.print(i + " ");
        }
        long t4 = System.currentTimeMillis();

        long t5 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
        long t6 = System.currentTimeMillis();

        log.info("System.out.println으로 루프 돌린 시간: " + (t4 - t3) + "ms");
        log.info("StringBuilder를 생성해 루프를 돌린 시간: " + (t6 - t5) + "ms");
    }
}
