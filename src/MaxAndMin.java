import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxAndMin {

    public String solution(String s) {
        List<Integer> integerList = splitStringToList(s);

        return integerList.get(0) + " " + integerList.get(integerList.size() - 1);
    }

    private List<Integer> splitStringToList(String target) {
        List<Integer> integerList = new ArrayList<>();
        String temp = target;

        while (temp.contains(" ")) {
            int delimiter = temp.indexOf(" ");
            integerList.add(Integer.parseInt(temp.substring(0, delimiter)));
            temp = temp.substring(delimiter + 1);
        }
        integerList.add(Integer.parseInt(temp));
        Collections.sort(integerList);
        return integerList;
    }

    public static void main(String[] args) {
        String s = "-23 81684 34 84 2 -3 81 69 57 -39 23 -9184";

        MaxAndMin mam = new MaxAndMin();
        mam.solution(s);

    }

}
