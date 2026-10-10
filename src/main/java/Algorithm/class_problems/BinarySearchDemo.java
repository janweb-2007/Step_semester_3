package algorithms.class_problems;

public class BinarySearchDemo {

    static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12};
        System.out.println(binarySearch(arr, 8));
        System.out.println(binarySearch(arr, 5));
    }
}