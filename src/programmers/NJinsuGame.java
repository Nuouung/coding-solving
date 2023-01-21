package programmers;

public class NJinsuGame {

    public static void main(String[] args) {
        NJinsuGame n = new NJinsuGame();
        System.out.println(n.solution(16, 16, 2, 2));
    }

    public String solution(int n, int t, int m, int p) {

        int nextNumber = 0;
        int turn = 1;
        String currentTarget = "0";

        StringBuilder sb = new StringBuilder();
        int currentTargetIndex = 0;
        while (sb.length() < t) {
            // 다음 숫자를 진법 변환한다.
            if (currentTargetIndex == currentTarget.length()) {
                nextNumber++;
                currentTarget = transformNumber(n, nextNumber);
                currentTargetIndex = 0;

                continue;
            }

            if (isMyTurn(turn, m, p)) {
                sb.append(currentTarget.charAt(currentTargetIndex));
            }

            turn++;
            currentTargetIndex++;
        }


        return sb.toString();
    }

    private boolean isMyTurn(int turn, int numberOfPeople, int myTurn) {
        // 등차수열로 내 턴을 구하려면 numberOfPeople * (횟수 - 1) + myTurn 이 필요함
        // 이 식을 바탕으로 내 턴을 구하기 위해서는 아래와 같은 계산식이 필요
        return (turn + (numberOfPeople - myTurn)) % numberOfPeople == 0;
    }

    private String transformNumber(int n, int nextNumber) {
        if (nextNumber == 0) {
            return "0";
        }

        int temp = nextNumber;
        StringBuilder sb = new StringBuilder();
        while (temp != 0) {
            String append;
            switch (temp % n) {
                case 10 :
                    append = "A";
                    break;
                case 11 :
                    append = "B";
                    break;
                case 12 :
                    append = "C";
                    break;
                case 13 :
                    append = "D";
                    break;
                case 14 :
                    append = "E";
                    break;
                case 15 :
                    append = "F";
                    break;
                default :
                    append = String.valueOf(temp % n);
            }
            sb.append(append);
            temp = temp / n;
        }

        return sb.reverse().toString();
    }
}
