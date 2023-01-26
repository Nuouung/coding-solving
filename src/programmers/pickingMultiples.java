package programmers;

public class pickingMultiples {
    public int[] solution(int n, int[] numlist) {
        int[] temp = new int[numlist.length];
        int resultIndex = 0;

        int howMany = 0;
        for (int num : numlist) {
            if (num % n == 0) {
                howMany++;
                temp[resultIndex] = num;
                resultIndex++;
            }
        }

        int[] result = new int[howMany];
        for (int i = 0; i < howMany; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}
