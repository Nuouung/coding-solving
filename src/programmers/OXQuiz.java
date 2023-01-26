package programmers;

public class OXQuiz {

    public static void main(String[] args) {
        OXQuiz o = new OXQuiz();
        o.solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"});
    }

    public String[] solution(String[] quiz) {
        String[] result = new String[quiz.length];
        int resultIndex = 0;

        for (String q : quiz) {
            String[] a = q.split(" = ");
            String[] b = a[0].split(" ");
            int x = Integer.parseInt(b[0]);
            int y = Integer.parseInt(b[2]);
            int z = Integer.parseInt(a[1]);

            if (b[1].equals("+")) {
                result[resultIndex] = (x + y == z) ? "O" : "X";
                resultIndex++;
                continue;
            }

            result[resultIndex] = (x - y == z) ? "O" : "X";
            resultIndex++;
        }

        return result;
    }
}
