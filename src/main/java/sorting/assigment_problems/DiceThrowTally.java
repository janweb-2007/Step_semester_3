package sorting.assigment_problems;

import java.util.Arrays;

public class DiceThrowTally {

    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) count[roll]++;

        StringBuilder countsStr = new StringBuilder("Counts: ");
        for (int v = 1; v <= 6; v++) {
            countsStr.append(v).append(":").append(count[v]);
            if (v < 6) countsStr.append("  ");
        }
        System.out.println(countsStr);

        int[] result = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                result[idx++] = v;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sorted = diceSort(new int[]{4, 1, 6, 4, 2, 1, 4});
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}