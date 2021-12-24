import java.util.Arrays;

public class IWantItMoreSpicy {

    public int solution(int[] spicyLevel, int K) {
        int count = 0;
        int lockPick = 1;
        Arrays.sort(spicyLevel);
        while (spicyLevel[0] < K) {
            if (spicyLevel[1] == 1000000001) {
                return -1;
            }

            int newSpicy = spicyLevel[0] + spicyLevel[1] * 2;
            spicyLevel[0] = newSpicy;
            for (int i = 1; i < spicyLevel.length; i++) {
                if (spicyLevel.length - lockPick <= i) {
                    spicyLevel[i] = 1000000001;
                    continue;
                }
                spicyLevel[i] = spicyLevel[i + 1];
            }
            lockPick++;
            count++;
            Arrays.sort(spicyLevel);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] spicyLevel = {1, 2};
        int K = 3;

        IWantItMoreSpicy ms = new IWantItMoreSpicy();
        System.out.println(ms.solution(spicyLevel, K));
    }
}
