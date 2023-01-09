package programmers;

public class AddArray {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] array = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return array;
    }
}
