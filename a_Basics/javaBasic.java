package a_Basics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class javaBasic {

    /* */
    public static void main(String[] args) {
        // Define hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        // print array
        System.out.println(Arrays.toString(new int[] { 2, 7, 11, 15 }));
        // print list of lists array
        List<int[]> result = new ArrayList<int[]>();
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
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
        // to print
        System.out.println(array1);
        // Define Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();
        stack.peek();// don't remove from the stack
        //Convert Stack to array
        int[] result1 = new int[stack.size()];
        int index = stack.size() - 1;

        while (!stack.isEmpty()) {
            result1[index--] = stack.pop();        }
        
        // Absolute value
        Math.abs(-5);
        // Modulus remainder
        int x = 6 % 5; // 1

    }
}
