import java.util.PriorityQueue;
import java.util.Queue;

public class IWantItMoreSpicy2 {

    public int solution(int[] spicyLevel, int K) {
        Queue<Integer> myQueue = new PriorityQueue<>();

        for (int s : spicyLevel) {
            myQueue.offer(s);
        }

        int count = 0;
        while (myQueue.peek() != null && myQueue.peek() < K) {
            if (myQueue.size() < 2) {
                return -1;
            }

            int noSpicyOne = myQueue.poll();
            if (myQueue.peek() != null) {
                int newSpice = noSpicyOne + myQueue.poll() * 2;

                if (myQueue.peek() < K) {
                    myQueue.offer(newSpice);
                }
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] spicyLevel = {1,1,2};
        int K = 3;

        IWantItMoreSpicy2 ms = new IWantItMoreSpicy2();
        System.out.println(ms.solution(spicyLevel, K));
    }
}
