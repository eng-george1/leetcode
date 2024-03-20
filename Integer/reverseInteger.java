package Integer;
public class reverseInteger {
    /*
     * https://leetcode.com/problems/reverse-integer/description/
     * Given a signed 32-bit integer x, return x with its digits reversed. If
     * reversing x causes the value to go outside the signed 32-bit integer range
     * [-231, 231 - 1], then return 0.
     * 
     * Assume the environment does not allow you to store 64-bit integers (signed or
     * unsigned).
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: x = 123
     * Output: 321
     * Example 2:
     * 
     * Input: x = -123
     * Output: -321
     * Example 3:
     * 
     * Input: x = 120
     * Output: 21
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(log10 n) SC: O(n)
     * #Notes
     * 2,147,483,647
     * -2,147,483,648
     * #Review
     */
    public int reverse(int x) {
        int result = 0;       
          while (x != 0) {
            //we have another number to be added so check before added 
              if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10 &&x>7))
              return 0;
              if(result<Integer.MIN_VALUE/10||(result==Integer.MIN_VALUE/10 &&x<-8))
              return 0;
              result = result*10+(x % 10) ;
              x = x / 10;          
          }
          return result;
      }
    public int reverse1(int x) {
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}