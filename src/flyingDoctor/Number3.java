package flyingDoctor;

import java.util.*;

public class Number3 {

    public static void main(String[] args) {
        Number3 n = new Number3();
        long s = System.currentTimeMillis();
        System.out.println(n.solution(6));
    }

    int age0 = 0;
    int age1 = 0;
    int age2 = 0;
    int age3 = 0;
    int age4 = 0;
    int age5 = 0;
    int overAge5 = 0;

    public int solution(int n) {
        age0++;

        for (int i = 1; i <= n; i++) {
            overAge5 = overAge5 + age5;
            age5 = age4;
            age4 = age3;
            age3 = age2;
            age2 = age1;
            age1 = age0;
            age0 = age2 + age3 + age4 + age5;
        }

        return (age0 + age1 + age2 + age3 + age4 + age5 + overAge5);
    }

    Map<Integer, Integer> dragonNest = new HashMap<>(); // 드래곤 둥지

    int numberOfDragon = 0;
    int index = 0;

    public int soluteion(int n) {
        // 초기 드래곤
        dragonNest.put(index++, 0);

        int oldDragons = 0;
        for (int i = 1; i <= n; i++) {
            int newDragons = 0;

            Set<Integer> removeKeySey = new HashSet<>();
            Set<Integer> dragonKeySet = dragonNest.keySet();
            for (Integer key : dragonKeySet) {
                dragonNest.put(key, dragonNest.get(key) + 1);

                if (2 <= dragonNest.get(key) && dragonNest.get(key) < 6) newDragons++;
                if (dragonNest.get(key) >= 6) {
                    oldDragons++;
                    removeKeySey.add(key);
                }
            }

            for (int j = 0; j < newDragons; j++) {
                dragonNest.put(index++, 0);
            }

            for (Integer key : removeKeySey) {
                dragonNest.remove(key);
            }
        }

        return dragonNest.size() + oldDragons;
    }

    class Dragon {
        int age; // 2일에 부화 + 알 하나 낳음. 5일까지 알 하나를 낳고, 6일차부터는 알을 낳지 않음

        public Dragon() {
            // 생성자는 자동으로 값을 바인딩 (나이는 0으로 고정되어 태어나므로)
            age = 0;
        }

        void addAge() {
            age++;
        }
    }
}
