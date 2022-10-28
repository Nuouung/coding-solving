package baekjoon.basic2;

import java.util.*;

public class SevenDwarf {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] heights = new int[9];
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = in.nextInt();
            heights[i] = height;
            total += height;
        }

        List<Integer> sevenDwarf = new ArrayList<>();
        int[] blackList = new int[2];
        for (int i = 0; i < heights.length; i++) {
            boolean breakPoint = false;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] + heights[j] == (total - 100)) {
                    blackList[0] = i;
                    blackList[1] = j;
                    breakPoint = true;
                    break;
                }
            }

            if (breakPoint) break;
        }

        for (int i = 0; i < heights.length; i++) {
            if (i != blackList[0] && i != blackList[1]) sevenDwarf.add(heights[i]);
        }

        Collections.sort(sevenDwarf);

        for (Integer integer : sevenDwarf) {
            System.out.println(integer);
        }
    }
}
