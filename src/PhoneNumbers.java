import java.util.Arrays;

public class PhoneNumbers {

    public boolean solution(String[] phoneBook) {

        for (int i = 0; i < phoneBook.length - 1; i++) {
            for (int j = i + 1; j < phoneBook.length; j++) {
                if (phoneBook[i].startsWith(phoneBook[j]) || phoneBook[j].startsWith(phoneBook[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] ahahah = {"119", "97674223", "1195524421"};

        PhoneNumbers pn = new PhoneNumbers();
        pn.solution(ahahah);
    }

}
