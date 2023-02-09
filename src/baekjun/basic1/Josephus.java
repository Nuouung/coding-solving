package baekjun.basic1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Josephus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");

        List<Integer> linkedList = getList(Integer.parseInt(s[0]));
        int index = -1;
        int k = Integer.parseInt(s[1]);

        StringBuilder sb = new StringBuilder("<");

        while (linkedList.size() > 0) {
            index += k;
            while (index >= linkedList.size()) {
                index -= linkedList.size();
            }

            sb.append(linkedList.get(index)).append(", ");
            linkedList.remove(index);
            index--;
        }

        sb.replace(sb.length() - 2, sb.length(), ">");

        System.out.println(sb);
    }

    static List<Integer> getList(int n) {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i + 1);
        }

        return linkedList;
    }
}
