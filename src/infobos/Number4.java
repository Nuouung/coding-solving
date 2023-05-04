package infobos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number4 {

    public static void main(String[] args) {
        Number4 n = new Number4();
        String[] solution = n.solution(new String[]{"ABACDEFG", "NOPQRSTU", "HIIJKLKMM"}, new String[]{"GPQM", "GPMZ", "EFU", "MMNA"});

        for (String s : solution) {
            System.out.print(s + " ");
        }
    }

    Map<Character, CardInfo> alphabets = new HashMap<>();

    public String[] solution(String[] card, String[] word) {

        for (int i = 0; i < card.length; i++) {
            for (char c : card[i].toCharArray()) {
                if (alphabets.get(c) == null) {
                    alphabets.put(c, new CardInfo(i, 1));
                    continue;
                }

                CardInfo cardInfo = alphabets.get(c);
                cardInfo.increaseNumbers();

                alphabets.put(c, cardInfo);
            }
        }

        List<String> results = new ArrayList<>();
        for (String w : word) {

            boolean[] isDeck = new boolean[3];
            Map<Character, CardInfo> tempAlphabets = new HashMap<>(Map.copyOf(alphabets));

            boolean isCorrectWord = true;
            for (char c : w.toCharArray()) {
                if (tempAlphabets.get(c) == null) {
                    isCorrectWord = false;
                    break;
                }

                CardInfo cardInfo = tempAlphabets.get(c);
                CardInfo newCardInfo = new CardInfo(cardInfo.location, cardInfo.numbers);

                if (newCardInfo.numbers < 1) {
                    isCorrectWord = false;
                    break;
                }

                newCardInfo.decreaseNumbers();
                isDeck[cardInfo.location] = true;

                tempAlphabets.put(c, newCardInfo);
            }

            if (isCorrectWord)
                if (isDeck[0] && isDeck[1] && isDeck[2])
                    results.add(w);
        }

        return results.isEmpty() ?
                new String[]{"-1"} :
                results.toArray(new String[0]);
    }

    class CardInfo {
        int location;
        int numbers;

        public CardInfo(int location, int numbers) {
            this.location = location;
            this.numbers = numbers;
        }

        public void increaseNumbers() {
            numbers++;
        }

        public void decreaseNumbers() {
            numbers--;
        }
    }
}
