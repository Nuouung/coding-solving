public class AddNonExistNumber {

    public int solution(int[] numbers) {

        Boolean[] checkArray = new Boolean[10];

        for (int number : numbers) {
            checkArray[number] = true; // 예를 들어 3일 경우 3번째 checkArray 공간이 참이 된다
        }

        int result = 0;
        for (int i = 1; i < 10; i++) {
            if (checkArray[i] == null) {
                result += i;
            }
        }

        return result;
    }

}

class Version2 {

    public int solution(int[] numbers) {

        int result = 45; // 1부터 9까지 모두 더한 값

        for (int number : numbers) {
            result -= number;
        }

        return result;
    }
}
