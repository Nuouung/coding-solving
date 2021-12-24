public class Country124 {

    public static String solution(int target) {
        if (target <= 3) {
            if (target == 3) {
                return "4";
            }
            return Integer.toString(target);
        } else {
            if (target % 3 == 1) {
                return solution(target / 3) + "1";
            } else if (target % 3 == 2) {
                return solution(target / 3) + "2";
            } else {
                return solution(target / 3 - 1) + "4";
            }
        }
    }
}
