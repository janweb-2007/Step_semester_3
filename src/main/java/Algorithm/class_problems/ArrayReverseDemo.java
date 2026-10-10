package algorithms.class_problems;

import java.util.Arrays;

public class ArrayReverseDemo {

    static void reverseInPlace(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseInPlace(arr);
        System.out.println(Arrays.toString(arr));
    }
}