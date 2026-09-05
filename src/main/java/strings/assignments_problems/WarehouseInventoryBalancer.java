
package strings.assignments_problems;

public class WarehouseInventoryBalancer {

    public void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        for (int value : sectionA) totalA += value;
        for (int value : sectionB) totalB += value;

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int maxValue = sectionA[0];
        String maxSection = "Section A";
        int maxIndex = 1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxValue) {
                maxValue = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxValue) {
                maxValue = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB +
                " | Status: " + status + " | Highest Quantity: " + maxValue +
                " (" + maxSection + ", Item " + maxIndex + ")");
    }

    public static void main(String[] args) {
        WarehouseInventoryBalancer balancer = new WarehouseInventoryBalancer();
        balancer.analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}