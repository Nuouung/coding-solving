package baekjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IncreasingSubsequence4 {

    static Map<Integer, Entity> map = new HashMap<>();
    static long[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        init(n, br.readLine().split(" "));

        setMap(n);
        int result = getResult(n);

        System.out.println(map.get(result).number);
        for (long value : map.get(result).list) {
            System.out.print(value + " ");
        }
    }

    private static int getResult(int n) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (map.get(i).number > max) {
                index = i;
                max = map.get(i).number;
            }
        }

        return index;
    }

    private static void setMap(int n) {
        for (int i = 0; i < n; i++) {
            Entity entity = new Entity(1);
            entity.list.add(numbers[i]);

            map.put(i, entity);

            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j] && map.get(i).number <= map.get(j).number) {
                    map.get(i).number = map.get(j).number + 1;

                    List<Long> newList = new ArrayList<>(map.get(j).list);
                    newList.add(numbers[i]);

                    map.get(i).list = newList;
                }
            }
        }
    }

    private static void init(int n, String[] s) {
        numbers = new long[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(s[i]);
        }
    }

    static class Entity {
        int number;
        List<Long> list;

        public Entity(int number) {
            this.number = number;
            this.list = new ArrayList<>();
        }
    }
}
