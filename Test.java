//package ;

import PrefixSum.countTriplets;

public class Test {
    /*
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     */
    public int trap(int[] height) {
        int left=0,right=height.length-1,maxLeft=0,maxRight=0;//1,1
        int result=0;
        while (left<right) {//1,2
            if(height[left]<height[right]){
                maxLeft=Math.max(maxLeft, height[left]);
                result+=maxLeft-height[left];
                left++;
            }else{
                maxRight=Math.max(maxRight, height[right]);//1
                result+=Math.min(maxRight, maxLeft)-height[right];
                right--;
            }
        }
        return result;
    }
}