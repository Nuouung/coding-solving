package programmers;

public class MakeBigNumber {

    public static void main(String[] args) {
        MakeBigNumber m = new MakeBigNumber();
        System.out.println(m.solution("4177252841", 4));
    }

    public String solution(String number, int k) {

        int index = 0;
        int bignumber = 0;

        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            for (int i = k + 1; i >= 0; i--) {
                int n = Character.getNumericValue(number.charAt(i));
                if (n >= bignumber) {
                    bignumber = n;
                    index = i;
                }
            }

            sb.append(number.charAt(index));
            number = number.substring(index + 1);
            k = k - index;
            bignumber = 0;
        }
        return null;
    }
}
