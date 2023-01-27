package programmers;

public class RemoveSmallestNumber {
    public int[] solution(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                index = i;
            }
        }

        if (arr.length == 1) {
            return new int[]{-1};
        }

        int[] result = new int[arr.length - 1];
        int resultIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) continue;
            result[resultIndex++] = arr[i];
        }

        return result;
    }
}
