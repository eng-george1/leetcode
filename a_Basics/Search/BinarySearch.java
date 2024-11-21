package a_Basics.Search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11, 13 };
        int target = 7;

        int result = binarySearchWhile(arr, target);
        System.out.println("Target found at index (while loop): " + result);
    }

    public static int binarySearchWhile(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

    // it doesn't make sense
    public static int binarySearchFor(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        for (; left <= right;) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

}
