package Algorithm.assigment_problems;

import java.util.Arrays;

public class ExamScoreBandCounter {

    static int lowerBound(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (scores[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        int start = lowerBound(scores, low);
        int end = lowerBound(scores, high + 1);
        return end - start;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}