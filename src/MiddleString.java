public class MiddleString {

    public String solution(String s) {
        boolean symmetry = s.length() % 2 == 0;
        int middle = s.length() / 2;

        if (symmetry) {
            return s.substring(middle - 1, middle + 1);
        } else {
            return String.valueOf(s.charAt(middle));
        }
    }

    public static void main(String[] args) {
        String a = "12345";
        MiddleString m = new MiddleString();
        System.out.println(m.solution("123456"));
    }

}
