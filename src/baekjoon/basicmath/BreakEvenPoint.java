package baekjoon.basicmath;

import java.util.Scanner;

public class BreakEvenPoint {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int fixedCost = Integer.parseInt(s.split(" ")[0]);
        int variableCost = Integer.parseInt(s.split(" ")[1]);
        int price = Integer.parseInt(s.split(" ")[2]);

        boolean check = true;
        if (variableCost >= price) {
            System.out.println(-1);
            check = false;
        }

        if (check) {
            int numberOfSales = 1;
            while (fixedCost >= numberOfSales * (price - variableCost)) {
                numberOfSales++;
            }
            System.out.println(numberOfSales);
        }
    }
}
