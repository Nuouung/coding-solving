import java.util.ArrayList;
import java.util.List;

public class DevelopProcess {

    public static List<Integer> solution(int[] progresses, int[] speeds) {
        int LENGTH = progresses.length;
        System.out.println("LENGTH = " + LENGTH);
        int[] lastDays = new int[LENGTH];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < LENGTH; i++) {
            lastDays[i] = takeTime(progresses[i], speeds[i]);
        }

        int checkNum = 0;
        for (int i = 0; i < LENGTH; i++) {
            checkNum = lastDays[i];
            int count = 1;

            while (i != LENGTH - 1 && checkNum >= lastDays[i + 1]) {
                i++;
                count += 1;
            }

            result.add(count);
        }

        return result;
    }

    public static int takeTime(int progress, int speed) {
        int lastPercent = 100 - progress;
        int count = 0;

        while (lastPercent > 0) {
            count += 1;

            lastPercent -= speed;
        }

        return count;
    }
}


