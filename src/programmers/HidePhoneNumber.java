package programmers;

public class HidePhoneNumber {

    public static void main(String[] args) {
        String phone_number = "01033334444";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phone_number.length(); i++) {
            if (i >= phone_number.length() - 4) {
                sb.append(phone_number.charAt(i));
            } else {
                sb.append("*");
            }
        }

        System.out.println(sb);
    }

    public String solution(String phone_number) {
        String answer = "";
        return answer;
    }
}
