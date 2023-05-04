package flyingDoctor;

import java.util.*;

public class Number4 {

    public static void main(String[] args) {
        Number4 n = new Number4();
        int[] solution = n.solution(5, new int[][]{{1, 3}, {1, 4}, {3, 5}, {5, 4}});

        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited;

    public int[] solution(int n, int[][] quests) {
        visited = new boolean[n + 1];

        Map<Integer, List<Integer>> nodeMap = new HashMap();
        for (int i = 1; i <= n; i++) {
            nodeMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < quests.length; i++) {
            List<Integer> previous = nodeMap.get(quests[i][1]);
            previous.add(quests[i][0]);

            nodeMap.put(quests[i][1], previous);
        }


        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, nodeMap);
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = queue.poll();
        }

        return result;
    }

    public void dfs(int index, Map<Integer, List<Integer>> nodeMap) {
        visited[index] = true;

        List<Integer> previous = nodeMap.get(index);
        for (int previousIndex : previous) {
            if (!visited[previousIndex]) {
                dfs(previousIndex, nodeMap);
            }
        }

        queue.offer(index);
    }

    /*Map<Integer, Quest> questMap = new HashMap<>();
    Queue<Quest> questQueue = new LinkedList<>();
    Map<Integer, Boolean> completeMap = new HashMap<>();

    List<Integer> resultList = new ArrayList<>();

    public int[] solution(int n, int[][] quests) {
        setQuestMap(quests);

        for (int i = 1; i <= n; i++) {
            questQueue.offer(
                    questMap.get(i) == null ?
                            new Quest(i) :
                            questMap.get(i)
            );
        }

        while (!questQueue.isEmpty()) {
            Quest quest = questQueue.poll();

            if (quest.previousList == null || quest.isQuestAvailable()) {
                resultList.add(quest.number);
                completeMap.put(quest.number, true);
                continue;
            }

            questQueue.offer(quest);
        }

        return resultList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    private void setQuestMap(int[][] quests) {
        for (int[] q : quests) {
            if (questMap.get(q[1]) == null) {
                questMap.put(q[1], new Quest(q[1], q[0]));
                continue;
            }

            Quest quest = questMap.get(q[1]);
            quest.addPreviousList(q[0]);
        }
    }

    class Quest {
        int number;
        List<Integer> previousList;

        public Quest(int number) {
            this.number = number;
        }

        public Quest(int number, int previous) {
            this.number = number;

            List<Integer> tempList = new ArrayList<>();
            tempList.add(previous);

            this.previousList = tempList;
        }

        public void addPreviousList(int previous) {
            previousList.add(previous);
        }

        public boolean isQuestAvailable() {
            for (int previous : previousList) {
                if (completeMap.get(previous) == null) {
                    // 선행 퀘스트가 진행되지 않은 것이므로 false
                    return false;
                }
            }

            return true;
        }
    }*/
}
