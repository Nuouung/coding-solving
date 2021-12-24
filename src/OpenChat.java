import java.util.*;

public class OpenChat {

    private final Map<String, ArrayList<String>> sortMap = new HashMap<>();
    private final Map<String, String> nicknameMap = new HashMap<>();

    public List<String> solution(String[] record) {

        getNicknameMap(record);
        return myMessageResolver(record);
    }

    private List<String> myMessageResolver(String[] record) {
        List<String> answer = new ArrayList<>();
        for (String r : record) {
            String username = r.split(" ")[1];
            String userNickname = nicknameMap.get(r.split(" ")[1]);

            String command = r.split(" ")[0];
            switch (command) {
                case "Enter":
                    command = "들어왔습니다.";
                    break;
                case "Leave":
                    command = "나갔습니다.";
            }

            if (!command.equals("Change")) {
                answer.add(userNickname + "님이 " + command);
            }
        }
        return answer;
    }

    private void getNicknameMap(String[] record) {
        for (String r : record) {
            String username = r.split(" ")[1];
            if (sortMap.get(username) == null) {
                sortMap.put(username, new ArrayList<>());
            }
            sortMap.get(username).add(r);
        }

        for (ArrayList<String> value : sortMap.values()) {
            for (int i = value.size() - 1; i > -1; i--) {
                String target = value.get(i);
                String command = target.split(" ")[0];

                if (!command.equals("Leave")) {
                    nicknameMap.put(target.split(" ")[1], target.split(" ")[2]);
                    break;
                }
            }
        }
    }
}
