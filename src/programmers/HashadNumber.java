package programmers;

public class HashadNumber {

    public static void main(String[] args) {
        int a = 13;

        String b = Integer.toString(a);

        int d = 0;
        for (int i = 0; i < b.length(); i++) {
            d += Integer.parseInt(String.valueOf(b.charAt(i)));
        }

        if (a % d == 0) {
            System.out.println(true);
        }
    }
}
