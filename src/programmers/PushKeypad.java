package programmers;

public class PushKeypad {

    public static void main(String[] args) {
        PushKeypad p = new PushKeypad();
        System.out.println(p.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    public String solution(int[] numbers, String hand) {
        // +-------+
        // | 1 2 3 |
        // | 4 5 6 |
        // | 7 8 9 |
        // | * 0 # |
        // +-------+
        String[][] keypad = getKeypad();
        StringBuilder sb = new StringBuilder();
        int[] leftCoordinate = new int[]{3, 0};
        int[] rightCoordinate = new int[]{3, 2};

        for (int n : numbers) {
            int[] targetCoordinate = getCoordinate(n, keypad);

            if (targetCoordinate[1] == 0) {
                fingerMove(leftCoordinate, targetCoordinate);
                sb.append("L");
                continue;
            }

            if (targetCoordinate[1] == 2) {
                fingerMove(rightCoordinate, targetCoordinate);
                sb.append("R");
                continue;
            }

            int leftMove = Math.abs(targetCoordinate[0] - leftCoordinate[0]) + Math.abs(targetCoordinate[1] - leftCoordinate[1]);
            int rightMove = Math.abs(targetCoordinate[0] - rightCoordinate[0]) + Math.abs(targetCoordinate[1] - rightCoordinate[1]);

            if (leftMove == rightMove) {
                if (hand.equals("right")) {
                    fingerMove(rightCoordinate, targetCoordinate);
                    sb.append("R");
                } else {
                    fingerMove(leftCoordinate, targetCoordinate);
                    sb.append("L");
                }
            } else if (leftMove < rightMove) {
                fingerMove(leftCoordinate, targetCoordinate);
                sb.append("L");
            } else {
                fingerMove(rightCoordinate, targetCoordinate);
                sb.append("R");
            }
        }

        return sb.toString();
    }

    private String[][] getKeypad() {
        String[][] keypad = new String[4][3];
        keypad[0] = new String[]{"1", "2", "3"};
        keypad[1] = new String[]{"4", "5", "6"};
        keypad[2] = new String[]{"7", "8", "9"};
        keypad[3] = new String[]{"*", "0", "#"};
        return keypad;
    }

    private void fingerMove(int[] fingerCoordinate, int[] targetCoordinate) {
        fingerCoordinate[0] = targetCoordinate[0];
        fingerCoordinate[1] = targetCoordinate[1];
    }

    private int[] getCoordinate(int n, String[][] keypad) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < keypad.length; i++) {
            boolean escape = false;
            for (int j = 0; j < keypad[i].length; j++) {
                if (keypad[i][j].equals(Integer.toString(n))) {
                    x = i;
                    y = j;
                    escape = true;
                    break;
                }
            }

            if (escape) break;
        }

        return new int[]{x, y};
    }
}
