package programmers;

public class DesktopCleanup {

    public static void main(String[] args) {
        DesktopCleanup d = new DesktopCleanup();
        int[] solution = d.solution(new String[]{"..", "#."});
        System.out.print(solution[0] + " ");
        System.out.print(solution[1] + " ");
        System.out.print(solution[2] + " ");
        System.out.print(solution[3] + " ");
    }
    public int[] solution(String[] wallpaper) {
        int top = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '.') continue;

                if (top > i) top = i;
                if (bottom < i) bottom = i;
                if (left > j) left = j;
                if (right < j) right = j;
            }
        }

        return new int[]{top, left, bottom + 1, right + 1};
    }
}
