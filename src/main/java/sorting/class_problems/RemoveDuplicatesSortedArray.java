package sorting.assigment_problems;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, length)));
    }
}