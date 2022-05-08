public class NumberStringAndEnglishWord {

    public int solution(String target) {

        StringBuilder sb = new StringBuilder();
        while (target.length() > 0) {
            int[] numberInfo = ProblemResolver.whatAreYou(target);

            sb.append(numberInfo[0]); // 숫자를 넣고
            target = target.substring(numberInfo[1]); // 문자열을 쪼갠다
        }

        return Integer.parseInt(sb.toString());
    }
}

class ProblemResolver {

    // zero, one, two, three, four, five, six, seven, eight, nine
    // z 시작 1개 -> zero
    // o 시작 1개 -> one
    // t 시작 2개 -> two, three
    // f 시작 2개 -> four, five
    // s 시작 2개 -> six, seven
    // e 시작 1개 -> eight
    // n 시작 1개 -> nine
    // int[2] <= 영어에서 해석한 실제 수, 영어 단어의 낱말 수
    // ex) "zero" => {0(실제 수), 4(zero는 4개의 낱말 수를 가짐)}
    public static int[] whatAreYou(String target) {
        String index0 = target.substring(0, 1);
        switch (index0) {
            case "z" :
                return new int[]{0, 4};
            case "o" :
                return new int[]{1, 3};
            case "t" :
                return startWithT(target.substring(1, 2));
            case "f" :
                return startWithF(target.substring(1, 2));
            case "s" :
                return startWithS(target.substring(1, 2));
            case "e" :
                return new int[]{8, 5};
            case "n" :
                return new int[]{9, 4};
        }

        // 숫자가 들어온 경우 ex 1 2 3 4 5 6 7 8 9 0
        return new int[]{Integer.parseInt(index0), 1};
    }

    private static int[] startWithT(String index1) {
        if (index1.equals("w")) {
            // two
            return new int[]{2, 3};
        }

        // three
        return new int[]{3, 5};
    }

    private static int[] startWithF(String index1) {
        if (index1.equals("o")) {
            // four
            return new int[]{4, 4};
        }

        // five
        return new int[]{5, 4};
    }

    private static int[] startWithS(String index1) {
        if (index1.equals("i")) {
            // six
            return new int[]{6, 3};
        }

        // seven
        return new int[]{7, 5};
    }


}