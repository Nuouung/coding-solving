package infobos;

import java.util.*;

public class Number3 {

    public static void main(String[] args) {
        Number3 n = new Number3();
        n.solution(new String[]{"choi pizza sandwich pizza"});
    }

    Map<String, ClientOrder> clientOrderMap = new HashMap<>(); // 고객 거래 데이터를 담는 장부

    public String[] solution(String[] orders) {
        for (String massData : orders) {
            String[] dataArray = massData.split(" ");

            // 처음 온 고객이면 장부에 고객 정보를 새로 담는다
            if (clientOrderMap.get(dataArray[0]) == null) {
                doNewClientProcess(dataArray);
                continue;
            }

            doExistClientProcess(dataArray);
        }

        // 주문을 모두 받고 거래 장부에서 가장 많은 음식을 주문한 고객을 추출한다.
        int max = 0;
        for (ClientOrder clientOrder : clientOrderMap.values()) {
            if (clientOrder.orderFoodNumber > max)
                max = clientOrder.orderFoodNumber;
        }

        List<String> results = new ArrayList<>();
        for (ClientOrder clientOrder : clientOrderMap.values()) {
            if (clientOrder.orderFoodNumber == max)
                results.add(clientOrder.clientName);
        }

        Collections.sort(results);

        return results.toArray(new String[0]);
    }

    private void doExistClientProcess(String[] dataArray) {
        ClientOrder clientOrder = clientOrderMap.get(dataArray[0]);

        List<String> newOrder = new ArrayList<>();
        for (int i = 1; i < dataArray.length; i++)
            newOrder.add(dataArray[i]);

        clientOrder.addOrder(newOrder);
    }

    private void doNewClientProcess(String[] dataArray) {
        Map<String, Boolean> newClientOrderMap = new HashMap<>();
        int newOrderFoodNumber = 0;
        for (int i = 1; i < dataArray.length; i++) {
            if (newClientOrderMap.get(dataArray[i]) != null) continue;

            newClientOrderMap.put(dataArray[i], true);
            newOrderFoodNumber++;
        }

        clientOrderMap.put(
                dataArray[0], // 고객 이름
                new ClientOrder(dataArray[0], newClientOrderMap, newOrderFoodNumber) // 고객이 주문한 정보
        );
    }

    class ClientOrder {
        String clientName;

        Map<String, Boolean> orderedMap;
        int orderFoodNumber;

        public ClientOrder(String clientName, Map<String, Boolean> orderedMap, int orderFoodNumber) {
            this.clientName = clientName;
            this.orderedMap = orderedMap;
            this.orderFoodNumber = orderFoodNumber;
        }

        public void addOrder(List<String> newOrder) {
            for (String food : newOrder) {
                if (orderedMap.get(food) != null) continue; // 이미 주문한 메뉴이므로 패스

                orderedMap.put(food, true); // 새로운 메뉴를 주문 메뉴에 편입하고
                orderFoodNumber++; // 주문한 음식 갯수를 하나 늘려준다.
            }
        }
    }
}
