package programmers;

public class StringContainsPractice {

    public static void main(String[] args) {
        String a = "wRFejiWvnoqhellworldoErfishelloworldpPSdalx";
        String b = "helloworld";

        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        int bIndex = 0;

        for (int i = 0; i < aChar.length; i++) {
            if (aChar[i] == bChar[bIndex]) {
                bIndex++;
                if (bIndex == bChar.length) {
                    break;
                }

                continue;
            }

            bIndex = 0;
        }

        boolean isContain = (bIndex == bChar.length);
        System.out.println(isContain);
    }
}
