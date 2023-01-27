package programmers;

import java.util.HashSet;
import java.util.Set;

public class CuttingRollCake {

    public static void main(String[] args) {
        CuttingRollCake c = new CuttingRollCake();
        System.out.println(c.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    }

    public int solution(int[] topping) {
        int[] leftCount = getToppingCount(topping, "LEFT");
        int[] rightCount = getToppingCount(topping, "RIGHT");

        int result = 0;
        for (int i = 1; i < topping.length; i++) {
            if (leftCount[i - 1] == rightCount[i]) result++;
        }

        return result;
    }

    int[] getToppingCount(int[] topping, String direction) {
        Set<Integer> toppingSet = new HashSet<>();
        int[] toppingCount = new int[topping.length];

        if (direction.equals("LEFT")) {
            toppingCount[0] = 1;
            toppingSet.add(topping[0]);

            for (int i = 1; i < topping.length; i++) {
                toppingCount[i] = toppingCount[i - 1] + (toppingSet.contains(topping[i]) ? 0 : 1);
                toppingSet.add(topping[i]);
            }
        }

        if (direction.equals("RIGHT")) {
            toppingCount[topping.length - 1] = 1;
            toppingSet.add(topping[topping.length - 1]);

            for (int i = topping.length - 2; i >= 0; i--) {
                toppingCount[i] = toppingCount[i + 1] + (toppingSet.contains(topping[i]) ? 0 : 1);
                toppingSet.add(topping[i]);
            }
        }

        return toppingCount;
    }
}
