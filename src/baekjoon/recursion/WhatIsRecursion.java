package baekjoon.recursion;

import java.util.Scanner;

public class WhatIsRecursion {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        System.out.println(RecursionConst.FIRST_SENTENCE);

        ask(N - 1, 1);

        System.out.println(RecursionConst.END_LINE);
    }

    private static void ask(int N, int count) {
        String delimiter = "____";

        StringBuilder depth = new StringBuilder();
        depth.append(delimiter.repeat(Math.max(0, count)));

        if (N <= 0) {
            System.out.println(depth + RecursionConst.START_LINE);
            System.out.println(depth + RecursionConst.ANSWER);
            System.out.println(depth + RecursionConst.END_LINE);
        } else {
            System.out.println(depth + RecursionConst.START_LINE);
            System.out.println(depth + RecursionConst.MIDDLE_LINE_A);
            System.out.println(depth + RecursionConst.MIDDLE_LINE_B);
            System.out.println(depth + RecursionConst.MIDDLE_LINE_C);

            ask(N - 1, count + 1);

            System.out.println(depth + RecursionConst.END_LINE);
        }
    }
}

interface RecursionConst {
    String FIRST_SENTENCE = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n" +
            "\"재귀함수가 뭔가요?\"\n" +
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    String START_LINE = "\"재귀함수가 뭔가요?\"";
    String MIDDLE_LINE_A = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    String MIDDLE_LINE_B = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    String MIDDLE_LINE_C = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    String ANSWER = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    String END_LINE = "라고 답변하였지.";
}