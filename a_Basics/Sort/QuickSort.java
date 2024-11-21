package a_Basics.Sort;

import java.util.Arrays;

public class QuickSort {
    /*
     * https://www.youtube.com/playlist?list=PLOmdoKois7_FK-ySGwHBkltzB11snW7KQ
     * https://www.youtube.com/watch?v=Vtckgz38QHs&ab_channel=BroCode
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] array = new int[] { 5, 2, 3, 1 };
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    /*
     * TC:O(n^2) SC: O(1)
     * #Notes
     * divide-and-conquer algorithm
     * Choose pivot and check each item left or right the pivot and for each left
     * and right repeat with chose pivot and left and right
     * Worst case when choose wrong pivot and always one array(left/right)==0
     * https://www.geeksforgeeks.org/quick-sort/
     * Best, average O(nlogn) when you choose the correct pivot
     * Worst Case: O(n^2) when chose bad pivot and highly unbalanced partitions
     * When the array is already sorted and the pivot is always chosen as the
     * smallest or largest element.
     * Space Complexity: O(1)
     * Advantages:
     * 
     * Disadvantage:
     * O(n^2)
     * Not Stability: a not stable sorting algorithm
     * Not in-place
     * #LastReview
     * #Review
     * #Idea:
     * Adding isSwap to check if there is no swap this mean its sorted and we can
     * end
     * 
     */
    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    // [7,3,2,5,4,1,6]
    static int partition(int[] arr, int low, int high) {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // it use space complexity O(n)
    public static int[] quickSort(int[] array) {
        if (array.length < 2)
            return array;
        int pivot = array[0];
        int[] leftArr = new int[array.length - 1];
        int[] rightArr = new int[array.length - 1];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (pivot >= array[i]) {
                leftArr[leftIndex] = array[i];
                leftIndex++;
            } else {
                rightArr[rightIndex] = array[i];
                rightIndex++;
            }
        }
        int[] result = new int[array.length];
        if (leftIndex != 0) {
            // resize
            leftArr = Arrays.copyOf(leftArr, leftIndex);
            System.arraycopy(quickSort(leftArr), 0, result, 0, leftIndex);
        }
        if (rightIndex != 0) {
            rightArr = Arrays.copyOf(rightArr, rightIndex);
            System.arraycopy(quickSort(rightArr), 0, result, leftIndex + 1, rightIndex);
        }
        result[leftIndex] = pivot;
        return result;
    }
}