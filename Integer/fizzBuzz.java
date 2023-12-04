package Integer;

import java.util.ArrayList;
import java.util.List;

public class fizzBuzz {

    /*
     * https://leetcode.com/problems/fizz-buzz/
     * 
     * Given an integer n, return a string array answer (1-indexed) where:
     * 
     * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
     * answer[i] == "Fizz" if i is divisible by 3.
     * answer[i] == "Buzz" if i is divisible by 5.
     * answer[i] == i (as a string) if none of the above conditions are true.
     * 
     * 
     * Example 1:
     * 
     * Input: n = 3
     * Output: ["1","2","Fizz"]
     * Example 2:
     * 
     * Input: n = 5
     * Output: ["1","2","Fizz","4","Buzz"]
     * Example 3:
     * 
     * Input: n = 15
     * Output:
     * ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14"
     * ,"FizzBuzz"]
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(fizzBuzz(3));
    }
/*
 * TC:O(n) SC: O(n)
 */
    public static List<String> fizzBuzz(int n) {
        String[] ansStrings = new String[n];
        // the number is index 1 not zero
        for (int index = 1; index <= n; index++) {
            if (index % 3 == 0 && index % 5 == 0)
                ansStrings[index - 1] = "FizzBuzz";
            else if (index % 3 == 0)
                ansStrings[index - 1] = "Fizz";
            else if (index % 5 == 0)
                ansStrings[index - 1] = "Buzz";
            else
                ansStrings[index - 1] = String.valueOf(index);
        }
        return List.of(ansStrings);
    }
}