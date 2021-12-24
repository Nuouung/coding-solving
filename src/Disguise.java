import java.util.HashMap;
import java.util.Map;

public class Disguise {

    int solution(String[][] clothes) {

        Map<Integer, Integer> hashTable = createHashTable(clothes, new HashMap<>());
        int result = getNumbersOfCases(hashTable);

        return result;

    }

    int getNumbersOfCases(Map<Integer, Integer> hashTable) {
        int NUMBER_OF_CASE = 1;

        for (int key : hashTable.keySet()) {
            int value = hashTable.get(key);
            NUMBER_OF_CASE *= value + 1;
        }

        return (NUMBER_OF_CASE - 1);
    }

    Map<Integer, Integer> createHashTable(String[][] clothes, Map<Integer, Integer> hashTable) {
        int INDEX = 1;
        for (String[] strings : clothes) {
            int hashCode = createHashCode(strings[INDEX]);

            if (hashTable.get(hashCode) != null) {
                int PLUS_ONE = hashTable.get(hashCode) + 1;
                hashTable.put(hashCode, PLUS_ONE);
                continue;
            }
            hashTable.put(hashCode, 1);
        }

        return hashTable;
    }

    int createHashCode(String s) {
        int hashCode = 0;
        for (char c : s.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }
}
