package programmers;

public class BitWithin2 {

    public static void main(String[] args) {
        BitWithin2 b = new BitWithin2();
        for (long l : b.solution(new long[]{1,3,49,50,1023,104501,1240401,51924,12303,10203,10,3050125,1020501212})) {
            System.out.print(l + " ");
        }
    }

    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];
        int resultIndex = 0;

        for (long number : numbers) {
            String binary = toBinary(number);

            if (binary.charAt(binary.length() - 1) == '0') {
                result[resultIndex++] = number + 1;
                continue;
            }

            int firstZeroIndex = -1;
            for (int i = binary.length() - 1; i >= 0; i--) {
                if (binary.charAt(i) == '0') {
                    firstZeroIndex = i;
                    break;
                }
            }

            if (firstZeroIndex == -1) {
                result[resultIndex++] = toDecimal("10" + binary.substring(1));
                continue;
            }

            if (binary.length() - 1 - firstZeroIndex < 2) {
                result[resultIndex++] = number + 1;
                continue;
            }

            String s = "1".repeat(Math.max(0, binary.length() - 1 - firstZeroIndex - 1));
            long newBinary = toDecimal(binary.substring(0, firstZeroIndex) + "10" + s);
            result[resultIndex++] = newBinary;
        }

        return result;
    }

    long toDecimal(String binary) {
        long decimal = 0;
        long multiple = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            int number = Character.getNumericValue(binary.charAt(i));
            decimal += number * multiple;
            multiple *= 2;
        }

        return decimal;
    }

    String toBinary(long target) {
        StringBuilder sb = new StringBuilder();
        while (target > 0) {
            sb.append(target % 2);
            target = target / 2;
        }

        return sb.reverse().toString();
    }
}
