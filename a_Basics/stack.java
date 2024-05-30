package a_Basics;

import java.util.Stack;

public class stack {
    public static void main(String[] args) {

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
        // Convert Stack to array
        int[] result = stack.stream().mapToInt(i -> i).toArray();
    }
}
