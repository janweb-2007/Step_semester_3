package algorithms.assigment_problems;

import java.util.Arrays;

public class DutyRosterRotation {

    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }
}