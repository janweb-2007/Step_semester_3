package sorting.assigment_problems;

public class PairSumSorted {

    static int[] pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return new int[]{nums[left], nums[right]};
            else if (sum < target) left++;
            else right--;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result1 = pairSumSorted(new int[]{-4, -1, 0, 3, 5, 9}, 4);
        System.out.println(result1 != null ? "(" + result1[0] + ", " + result1[1] + ")" : "Not Found");

        int[] result2 = pairSumSorted(new int[]{1, 2, 3}, 100);
        System.out.println(result2 != null ? "(" + result2[0] + ", " + result2[1] + ")" : "Not Found");
    }
}