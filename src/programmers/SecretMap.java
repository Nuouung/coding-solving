package programmers;

public class SecretMap {

    public static void main(String[] args) {
        SecretMap s = new SecretMap();
        s.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            String sX = getBinary(arr1[i]);
            String sY = getBinary(arr2[i]);

            while (sX.length() < n) {
                sX = "0" + sX;
            }

            while (sY.length() < n) {
                sY = "0" + sY;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (sX.charAt(j) == '1' || sY.charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }

            result[i] = sb.toString();
        }

        return result;
    }

    String getBinary(int x) {
        StringBuilder sX = new StringBuilder();
        while (x != 0) {
            sX.append(x % 2);
            x = x / 2;
        }

        return sX.reverse().toString();
    }
}
