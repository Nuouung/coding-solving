public class Year2016 {

    public static String solution(int a, int b) {

        a = convertMonth(a);

        int today = a + b;
        int week = 7;
        String result = "";

        switch(today % week) {
            case 1:
                result = "FRI";
                break;
            case 2:
                result = "SAT";
                break;
            case 3:
                result = "SUN";
                break;
            case 4:
                result = "MON";
                break;
            case 5:
                result = "TUE";
                break;
            case 6:
                result = "WED";
                break;
            case 0:
                result = "THU";
        }

        return result;
    }

    public static int convertMonth(int month) {

        int result = 0;
        switch(month) {
            case 12:
                result += 30;
            case 11:
                result += 31;
            case 10:
                result += 30;
            case 9:
                result += 31;
            case 8:
                result += 31;
            case 7:
                result += 30;
            case 6:
                result += 31;
            case 5:
                result += 30;
            case 4:
                result += 31;
            case 3:
                result += 29;
            case 2:
                result += 31;
            case 1:
                result += 0;
        }

        return result;
    }

    public static void main(String[] args) {
        solution(5, 25);
    }
}
