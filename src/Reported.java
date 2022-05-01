import java.util.*;

public class Reported {

    public int[] solution(String[] idList, String[] report, int k) {

        // 1. 신고한 사람의 신고 리스트를 추출한다.
        Map<String, HashSet<String>> userReportMap = getUserReportMap(idList, report);

        // 2. 신고 받은 사람의 수를 카운팅한다.
        Map<String, Integer> reportCountMap = getReportCountMap(idList, userReportMap);

        // 3. 계정 이용 정지된 사람을 구한다.
        List<String> blockedUserList = getBlockedUserList(k, reportCountMap);

        // 4. 정답을 제출한다. (계정 정지된 사람들과 회원이 신고한 리스트를 대조)
        return getAnswer(idList, userReportMap, blockedUserList);
    }

    private Map<String, HashSet<String>> getUserReportMap(String[] idList, String[] report) {
        // userReportMap을 만들고 초기화한다.
        Map<String, HashSet<String>> userReportMap = new HashMap<>();
        for (String user : idList) {
            userReportMap.put(user, new HashSet<>()); // key : user 이름, value : user가 신고한 회원 리스트(실제로는 set이지만)
        }

        // 각각의 회원이 신고한 회원을 추출해 userReportMap에 넣는다.
        for (String s : report) {
            String fromWho = s.split(" ")[0];
            String reportedUser = s.split(" ")[1];

            HashSet<String> userReportSet = userReportMap.get(fromWho);
            userReportSet.add(reportedUser);
        }

        return userReportMap;
    }

    private Map<String, Integer> getReportCountMap(String[] idList, Map<String, HashSet<String>> userReportMap) {
        // 회원을 한 명씩 꺼내 그 회원이 총 몇 번 신고 당했는지 구해 getReportCountMap에 담는다.
        Map<String, Integer> reportCountMap = new HashMap<>();

        for (String s : idList) {
            // 회원이 신고한 userReportMap을 가져와 자신이 신고당한 횟수를 카운팅한다.
            int reportedCount = 0;
            for (String key : userReportMap.keySet()) {
                if (key.equals(s)) {
                    continue;
                }

                HashSet<String> reportSet = userReportMap.get(key);
                for (String reportedUser : reportSet) {
                    // reportSet에는 자신의 이름이 있거나, 없거나 둘 중 하나.
                    // 따라서 순회 도중 자신의 이름이 발견되면 카운팅을 1 늘리고 해당 for문을 종료시킨다.
                    if (reportedUser.equals(s)) {
                        reportedCount++;
                        break;
                    }
                }
            }

            // 신고 당한 횟수를 userCountMap에 담는다.
            reportCountMap.put(s, reportedCount);
        }

        return reportCountMap;
    }

    private List<String> getBlockedUserList(int k, Map<String, Integer> reportCountMap) {
        // 계정 이용 정지된 회원들만 따로 담은 리스트
        List<String> blockedUserList = new ArrayList<>();
        for (String s : reportCountMap.keySet()) {
            // 신고당한 횟수가 k 보다 크거가 같다면 blockedUserList에 추가
            if (reportCountMap.get(s) >= k) {
                blockedUserList.add(s);
            }
        }

        return blockedUserList;
    }

    private int[] getAnswer(String[] idList, Map<String, HashSet<String>> userReportMap, List<String> blockedUserList) {
        int[] answer = new int[idList.length];
        for (int i = 0; i < idList.length; i++) {
            String user = idList[i];
            HashSet<String> reportSetOfUser = userReportMap.get(user);

            for (String reportOfUser : reportSetOfUser) {
                for (String blockedUser : blockedUserList) {
                    if (reportOfUser.equals(blockedUser)) {
                        answer[i] += 1;
                        break;
                    }
                }
            }
        }
        return answer;
    }

}
