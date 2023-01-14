package programmers;

public class Dictionary {

    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        System.out.println(d.solution("EIO"));
    }

    public int solution(String word) {
        StringBuilder current = new StringBuilder("A");
        String[] alphabetArray = new String[]{"A", "E", "I", "O", "U"};

        int result = 1;
        while (!current.toString().equals(word)) {
            result++;

            if (current.length() < 5) {
                current.append("A");
                continue;
            }

            int level = 4;
            int currentIndex = 0;
            for (int i = 0; i < alphabetArray.length; i++) {
                if (String.valueOf(current.charAt(level)).equals(alphabetArray[i])) {
                    current.replace(level, level + 1, (i == 4) ? "" : alphabetArray[i + 1]);
                    currentIndex = i;
                    break;
                }
            }

            boolean isShift = (currentIndex == 4);
            level--;
            while (isShift) {
                for (int i = 0; i < alphabetArray.length; i++) {
                    if (String.valueOf(current.charAt(level)).equals(alphabetArray[i])) {
                        current.replace(level, level + 1, (i == 4) ? "" : alphabetArray[i + 1]);
                        currentIndex = i;
                        break;
                    }
                }

                isShift = (currentIndex == 4);
                level--;
            }
        }

        return result;
    }

}
