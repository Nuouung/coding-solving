package baekjoon.basicmath1;

import java.math.BigInteger;
import java.util.Scanner;

public class ASumB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BigInteger a = new BigInteger(in.next());
        BigInteger b = new BigInteger(in.next());

        BigInteger sum = a.add(b);
        System.out.println(sum);

    }

}
