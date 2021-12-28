import java.util.*;

public class TruckOnTheBridge {

    public int solution(int bridgeLength, int weight, int[] truckWeights) {

        int[] bridge = new int[bridgeLength];
        List<Integer> trucks = makeTrucksList(truckWeights);

        return operateTruckTransportation(bridgeLength, weight, bridge, trucks);
    }

    private List<Integer> makeTrucksList(int[] truckWeights) {
        List<Integer> trucks = new ArrayList<>();
        for (int truckWeight : truckWeights) {
            trucks.add(truckWeight);
        }
        return trucks;
    }

    private int operateTruckTransportation(int bridgeLength, int weight, int[] bridge, List<Integer> trucks) {
        int count = 0;
        while (!trucks.isEmpty() || Arrays.stream(bridge).sum() != 0) {
            // 1. 다리 내에 있는 트럭들을 한 칸씩 전진
            if (bridgeLength - 1 >= 0) System.arraycopy(bridge, 0, bridge, 1, bridgeLength - 1);
            bridge[0] = 0;

            // 2. 조건이 충족되면 대기열에 있는 트럭을 다리에 올린다
            if (!trucks.isEmpty() && Arrays.stream(bridge).sum() + trucks.get(0) <= weight) {
                bridge[0] = trucks.get(0);
                trucks.remove(0);
            }

            count++;
        }
        return count;
    }
}
