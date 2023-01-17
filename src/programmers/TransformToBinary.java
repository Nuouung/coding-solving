package programmers;

public class TransformToBinary {

    private int removedZero = 0;
    private int numberOfTransform = 0;

    public static void main(String[] args) {
        TransformToBinary t = new TransformToBinary();
        System.out.println(t.solution("110010101001"));
    }

    public int[] solution(String s) {
        StringBuilder sb1 = new StringBuilder();
        for (char c : s.toCharArray()) { // 0 = 48, 1 = 49
            if (c == 48) {
                removedZero++;
            } else {
                sb1.append("1");
            }
        }

        int n = sb1.length();
        StringBuilder sb2 = new StringBuilder();
        while (n != 0) {
            sb2.append(n % 2);
            n = n / 2;
        }

        sb2 = sb2.reverse();
        numberOfTransform++;

        if (!sb2.toString().equals("1")) {
            solution(sb2.toString());
        }

        return new int[]{numberOfTransform, removedZero};
    }
}
