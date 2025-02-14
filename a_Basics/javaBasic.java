package a_Basics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class javaBasic {

    /* */
    public static void main(String[] args) {
        // Define hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        // to check if the key exist add to the list if not create new one
        HashMap<Integer, List<Integer>> map1 = new HashMap<>();
        map1.computeIfAbsent(5, k -> new ArrayList<>()).add(3);
        // print array
        System.out.println(Arrays.toString(new int[] { 2, 7, 11, 15 }));
        // print list of lists array
        List<int[]> result = new ArrayList<int[]>();
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
        // convert to 2D array
       int[][] result2= result.toArray(new int[result.size()][]);
        // print 2D array
        int[][] array = new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        System.out.println(Arrays.deepToString(array));
        // to check if letter or digit
        String s = "Geo12@34&#";
        Character.isLetterOrDigit(s.charAt(6));
        Character.toLowerCase(s.charAt(1));
        // Initialize List
        List<List<Integer>> array1 = new ArrayList<>();
        array1.add(Arrays.asList(1, 2, 3, 4));
        int[][] array2 = array1.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        // to print
        System.out.println(array1);
        // Define Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();
        stack.peek();// don't remove from the stack
        // Convert Stack to array
        int[] result1 = new int[stack.size()];
        int index = stack.size() - 1;

        while (!stack.isEmpty()) {
            result1[index--] = stack.pop();
        }
        // Create a Queue
        Queue<Integer> queue = new LinkedList<>();
        // Adding elements to the queue
        queue.add(1);
        queue.offer(2);
        queue.poll();
        queue.peek();
        queue.remove();

        // Initialize a Deque using ArrayDeque
        Deque<String> deque = new ArrayDeque<>();

        // Adding elements to both ends
        //all methods in queue and stack are there with first and last except push and pop
        deque.addFirst("Element 1 (Front)"); // Adding to the front
        deque.addLast("Element 2 (End)"); // Adding to the end
        deque.getFirst();
        deque.getLast();

        // Absolute value
        Math.abs(-5);
        // Modulus remainder
        int x = 6 % 5; // 1
        // define min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < 5; i++) {
            minHeap.offer(i);// same like add but without exception if the heap full
        }
        minHeap.poll();// remove the root(min)
        minHeap.peek();// get root element without remove it
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // insertion logn peek o(1) delete max or min logn
        // orders elements based on the second element of the integer arrays it contains
        // Descending
        PriorityQueue<int[]> pqMax = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        // Ascending
        PriorityQueue<int[]> pqMin = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int[][] array2D = new int[3][3];
        int nr = array2D.length;
        int nc = array2D[0].length;
        // In a 2D array, you can convert any element located at item[r][c] to a 1D
        // array index using the formula:
        // Row-Major Order
        // index = r * nc + c
        // To convert it back from a 1D index to 2D coordinates:
        // r = index / nc
        // c = index % nc

        // Column-Major Order
        // index = c * nr + r
        // To convert it back from a 1D index to 2D coordinates:
        // r = index % nr
        // c = index / nr
    }
}
