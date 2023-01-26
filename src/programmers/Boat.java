package programmers;

import java.util.Arrays;

public class Boat {

    public static void main(String[] args) {
        Boat b = new Boat();
        System.out.println(b.solution(new int[]{10,20,30,40,50,60,70,80,90}, 100));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--) {
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }

        return answer;
    }
}
