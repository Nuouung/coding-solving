package programmers;

import java.util.HashMap;
import java.util.Map;

public class NumberOfVisit {

    public static void main(String[] args) {
        NumberOfVisit n = new NumberOfVisit();
        System.out.println(n.solution("ULURRDLLU"));
    }

    Map<String, Integer> visited = new HashMap<>(); // x y 방향. ex) 1 1 U (1,1 좌표를 Up 방향으로 방문)
    int[] currentLocation = new int[2];
    Map<Character, int[]> operationMap = new HashMap<>();

    public int solution(String dirs) {
        setInitializedLocation();
        setInitializedOperation();

        int result = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int[] operation = operationMap.get(dirs.charAt(i));

            int operationX = operation[0];
            int operationY = operation[1];

            currentLocation[0] = currentLocation[0] + operationX;
            currentLocation[1] = currentLocation[1] + operationY;

            if (currentLocation[0] < 0 || currentLocation[0] > 10) {
                currentLocation[0] = currentLocation[0] - operationX;
            }

            if (currentLocation[1] < 0 || currentLocation[1] > 10) {
                currentLocation[1] = currentLocation[1] - operationY;
            }

            String coordinateAndDirection = currentLocation[0] + " " + currentLocation[1] + " " + dirs.charAt(i);
            if (visited.get(coordinateAndDirection) == null) {
                result++;
                visited.put(coordinateAndDirection, 1);
            }
        }

        return result;
    }

    private void setInitializedLocation() {
        currentLocation[0] = 5; // x
        currentLocation[1] = 5; // y
    }

    private void setInitializedOperation() {
        operationMap.put('U', new int[]{0, 1});
        operationMap.put('L', new int[]{-1, 0});
        operationMap.put('R', new int[]{1, 0});
        operationMap.put('D', new int[]{0, -1});
    }
}
