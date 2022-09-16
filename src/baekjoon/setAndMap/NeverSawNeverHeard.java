package baekjoon.setAndMap;

import java.util.*;

public class NeverSawNeverHeard {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        in.nextLine();

        Map<String, Integer> neverHeardMap = new HashMap<>();
        while(N > 0) {
            neverHeardMap.put(in.nextLine(), 0);
            N--;
        }

        int count = 0;
        ArrayList<String> neverSawNeverHeardList = new ArrayList<>();
        while (M > 0) {
            String currentLine = in.nextLine();
            if (neverHeardMap.containsKey(currentLine)) {
                count++;
                neverSawNeverHeardList.add(currentLine);
            }

            M--;
        }
        in.close();

        Collections.sort(neverSawNeverHeardList);

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for (String s : neverSawNeverHeardList) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
