package programmers;

public class BacktrackingPractice {

    private static boolean[] checkArray;
    private static int[] targetArray;
    private static int[] storageArray;
    private static int storageIndex = 0;
    private static int targetDepth;

    public static void main(String[] args) {
        checkArray = new boolean[6];
        targetArray = new int[]{1, 2, 3, 4, 5, 6};
        storageArray = new int[3];
        targetDepth = 3;
        backtracking(0);
    }

    private static void backtracking(int depth) {
        if (depth == targetDepth) {
            System.out.println(storageArray[0] + " " + storageArray[1] + " " + storageArray[2]);
            return;
        }

        for (int i = 0; i < targetArray.length; i++) {
            if (checkArray[i]) continue;

            checkArray[i] = true;
            storageArray[storageIndex] = i + 1;
            storageIndex++;

            backtracking(depth + 1);

            checkArray[i] = false;
            storageArray[--storageIndex] = 0;
        }
    }
}
