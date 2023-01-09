package programmers;

public class ClosestNumber {

    public static void main(String[] args) {
        ClosestNumber c = new ClosestNumber();
        int[] aArray = c.solution("abcda");
        for (int i : aArray) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String s) {
        int[] alphabetArray = new int[26];
        int[] resultArray = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int alphabetIndex = s.charAt(i) - 97;
            if (alphabetArray[alphabetIndex] != 0) {
                resultArray[i] = (i + 1) - alphabetArray[alphabetIndex];
            } else {
                resultArray[i] = -1;
            }

            alphabetArray[alphabetIndex] = (i + 1);
        }

        return resultArray;
    }
}
