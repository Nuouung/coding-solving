package programmers;

import java.util.*;

public class SortFilename {

    public static void main(String[] args) {
        SortFilename s = new SortFilename();
//        s.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
        s.solution(new String[]{"F15"});
    }

    Map<String, Stack<String>> myMap = new HashMap<>();
    List<String> headNameList = new ArrayList<>();

    public String[] solution(String[] files) {
        for (String file : files) {
            // number의 시작 위치를 구함
            int firstNumberIndex = getFirstNumberIndex(file);

            // map에 저장하고 map 내부에 데이터가 있으면 stack 내부에서 정렬 시행
            String head = file.substring(0, firstNumberIndex);
            if (myMap.get(head.toLowerCase()) == null) {
                Stack<String> myStack = new Stack<>();
                myStack.push(file);

                myMap.put(head.toLowerCase(), myStack);
                headNameList.add(head.toLowerCase());
                continue;
            }

            Stack<String> myStack = myMap.get(head.toLowerCase());
            Stack<String> tempStack = new Stack<>();
            int currentNumber = getNumber(file, firstNumberIndex);

            while (true) {
                // 스택이 비어 있으면(즉, 넣고자 하는 파일이 가장 앞에까지 왔다면) 파일을 그냥 넣고 루프 종료
                if (myStack.isEmpty()) {
                    myStack.push(file);

                    while (!tempStack.isEmpty()) {
                        myStack.push(tempStack.pop());
                    }

                    break;
                }

                String pop = myStack.pop();
                int popNumber = getNumber(pop, getFirstNumberIndex(pop));

                // 넣고자 하는 파일이 이전 정렬된 파일보다 숫자가 작다면 한칸 앞으로 옮기고 루프 계속 시행
                if (currentNumber < popNumber) {
                    // pop 임시스택에 임시 저장
                    tempStack.push(pop);

                    continue;
                }

                // 넣고자 하는 파일이 이전 정렬된 파일보다 숫자가 크거나 같다면 꺼낸 pop과 파일을 순서대로 넣고 루프 종료
                myStack.push(pop);
                myStack.push(file);

                while (!tempStack.isEmpty()) {
                    myStack.push(tempStack.pop());
                }

                break;
            }
        }

        // map의 키값(head)를 기준으로 head 정렬 시행
        Collections.sort(headNameList);

        String[] result = new String[files.length];
        int resultIndex = 0;
        for (String head : headNameList) {
            Stack<String> myStack = myMap.get(head);

            // stack을 개선된 for문으로 돌리면 바닥에 있는 것부터 출력된다.
            for (String s : myStack) {
                result[resultIndex] = s;
                resultIndex++;
            }
        }

        // 출력
       return result;
    }

    private int getFirstNumberIndex(String file) {
        int numberStartIndex = 0;
        for (int i = 0; i < file.length(); i++) {
            if ('0' <= file.charAt(i) && file.charAt(i) <= '9') {
                numberStartIndex = i;
                break;
            }
        }

        return numberStartIndex;
    }

    private int getNumber(String file, int numberStartIndex) {
        int numberEndIndex = numberStartIndex;
        for (int i = numberStartIndex; i < file.length(); i++) {
            if (i == numberStartIndex + 5) {
                return Integer.parseInt(file.substring(numberStartIndex, i));
            }

            if ('0' > file.charAt(i) || '9' < file.charAt(i)) {
                numberEndIndex = i;
                break;
            }
        }

        return Integer.parseInt(file.substring(numberStartIndex, numberEndIndex == numberStartIndex ? numberStartIndex + 1 : numberEndIndex));
    }
}
