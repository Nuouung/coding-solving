import java.util.ArrayList;
import java.util.List;

public class StringCompression {

    public int solution(String s) {
        int MIN_DIVISION = 1;
        int MAX_DIVISION = s.length() / 2;
        return getMaxCompression(s, MIN_DIVISION, MAX_DIVISION);
    }

    private int getMaxCompression(String s, int MIN_DIVISION, int MAX_DIVISION) {
        int result = s.length();
        for (int currentDivision = MIN_DIVISION; currentDivision <= MAX_DIVISION; currentDivision++) {
            String representative = s;
            int compressed = compressResolver(currentDivision, representative);

            if (compressed < result) {
                result = compressed;
            }
        }
        return result;
    }

    public int compressResolver(int division, String target) {
        List<String> list = new ArrayList<>();
        while (target.length() >= division) {
            list.add(target.substring(0, division));
            target = target.substring(division);
        }

        int result = 0;
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            String compareA = list.get(i - 1);
            String compareB = list.get(i);

            if (compareA.equals(compareB)) {
                count++;
            } else {
                if (count == 1) {
                    result += division;
                } else {
                    result += String.valueOf(count).length() + division;
                    count = 1;
                }
            }
            if (i == list.size() - 1) {
                if (count != 1) {
                    result += String.valueOf(count).length() + division;
                } else {
                    result += division;
                }
            }
        }
        return result + target.length();
    }
}
