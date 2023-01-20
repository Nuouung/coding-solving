package programmers;

public class DartGame {

    public static void main(String[] args) {
        DartGame d = new DartGame();
        System.out.println(d.solution("1D2S3T*"));
    }

    public int solution(String dartResult) {
        int[] numberArray = {-1, -1, -1}; // 1회 2회 3회
        StringBuilder sb = new StringBuilder();
        int numberArrayIndex = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            // '0' = 48, '9' = 57
            if (48 <= dartResult.charAt(i) && dartResult.charAt(i) <= 57) {
                sb.append(dartResult.charAt(i));
                continue;
            }

            switch (dartResult.charAt(i)) {
                case 'S' :
                    numberArray[numberArrayIndex] = Integer.parseInt(sb.toString());
                    numberArrayIndex++;
                    sb.delete(0, sb.length());
                    break;
                case 'D' :
                    numberArray[numberArrayIndex] = (int) Math.pow(Integer.parseInt(sb.toString()), 2);
                    numberArrayIndex++;
                    sb.delete(0, sb.length());
                    break;
                case 'T' :
                    numberArray[numberArrayIndex] = (int) Math.pow(Integer.parseInt(sb.toString()), 3);
                    numberArrayIndex++;
                    sb.delete(0, sb.length());
                    break;
            }

            switch (dartResult.charAt(i)) {
                case '*' :
                    numberArray[numberArrayIndex - 1] = numberArray[numberArrayIndex - 1] * 2;
                    if (numberArrayIndex - 1 != 0) {
                        numberArray[numberArrayIndex - 2] = numberArray[numberArrayIndex - 2] * 2;
                    }

                    break;
                case '#' :
                    numberArray[numberArrayIndex - 1] = numberArray[numberArrayIndex - 1] * -1;
            }
        }

        return numberArray[0] + numberArray[1] + numberArray[2];
    }
}
