package Algorithm.assigment_problems;

public class ClassAttendanceTracker {

    static int[] attendanceSummary(int[] days) {
        int present = 0, current = 0, longest = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                current++;
                longest = Math.max(longest, current);
            } else {
                current = 0;
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        int[] result1 = attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        System.out.println("Present: " + result1[0] + ", Longest streak: " + result1[1]);

        int[] result2 = attendanceSummary(new int[]{0, 0, 0});
        System.out.println("Present: " + result2[0] + ", Longest streak: " + result2[1]);
    }
}