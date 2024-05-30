package StacksQueues;

import java.util.Arrays;
import java.util.Stack;

public class asteroidCollision {
    /*
     * https://leetcode.com/problems/asteroid-collision/description/
     * 735. Asteroid Collision
     * 
     * We are given an array asteroids of integers representing asteroids in a row.
     * 
     * For each asteroid, the absolute value represents its size, and the sign
     * represents its direction (positive meaning right, negative meaning left).
     * Each asteroid moves at the same speed.
     * 
     * Find out the state of the asteroids after all collisions. If two asteroids
     * meet, the smaller one will explode. If both are the same size, both will
     * explode. Two asteroids moving in the same direction will never meet.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: asteroids = [5,10,-5]
     * Output: [5,10]
     * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never
     * collide.
     * Example 2:
     * 
     * Input: asteroids = [8,-8]
     * Output: []
     * Explanation: The 8 and -8 collide exploding each other.
     * Example 3:
     * 
     * Input: asteroids = [10,2,-5]
     * Output: [10]
     * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide
     * resulting in 10.
     * 
     * 
     * Constraints:
     * 
     * 2 <= asteroids.length <= 104
     * -1000 <= asteroids[i] <= 1000
     * asteroids[i] != 0
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(Arrays.toString(asteroidCollision(new int[] { 5, 10, -5 })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] { 8, -8 })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] { -2, -2, 1, -1 })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] { 2, 2, 1, -3 })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] { -2, 1, -1, -2 })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] { 1, -1, -2, -2 })));

    }

    /*
     * TC:O(2n) because the while loop may need to traverse the whole stack  SC: O(n) 
     * #Notes
     * #Review
     * #Idea: Use Stack to get the previous items as it needed
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
                // the current value is negative
            } else {
                // remove all positive values and less than the current value
                while ((!stack.empty() && stack.peek() > 0 && Math.abs(asteroids[i]) > stack.peek())) {
                    stack.pop();
                }
                // stack contains negative value or empty
                if (stack.empty() || stack.peek() < 0)
                    stack.push(asteroids[i]);
                // Two values equal with different sign
                else if (asteroids[i] + stack.peek() == 0)
                    stack.pop();
            }
        }
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;

        while (!stack.isEmpty()) {
            result[index--] = stack.pop();
        }
        return result;
    }
    public static int[] asteroidCollision11(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int ast: asteroids) {
            if (ast > 0) stack.push(ast);
            else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -ast)
                    stack.pop();
                if (stack.isEmpty() || stack.peek() < 0) stack.push(ast);
                if (stack.peek() == -ast) stack.pop();
            }
        }

        //int[] asteroidsPostCollision = new int[stack.size()];
        //for(int i = stack.size()-1; i >= 0; i--) asteroidsPostCollision[i] = stack.pop();
        //return asteroidsPostCollision;
        return stack.stream().mapToInt(i->i).toArray();
    }
// this  my initial solution there is an efficient conditions 
    public static int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            // Negative --> Positive
            if (asteroids[i] < 0 && (!stack.empty() && stack.peek() > 0)) {
                // Destroy
                while (!stack.empty() && stack.peek() > 0 && Math.abs(asteroids[i]) > stack.peek()) {
                    stack.pop();
                }
                if (!stack.empty() && Math.abs(asteroids[i]) == stack.peek()) {
                    // Destroyed each other
                    stack.pop();
                    continue;
                } else if (!(!stack.empty() && stack.peek() > 0))
                    stack.push(asteroids[i]);
            } else
                stack.push(asteroids[i]);
        }
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;

        while (!stack.isEmpty()) {
            result[index--] = stack.pop();
        }
        return result;
    }
}
