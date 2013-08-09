package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-10
 * Time: 上午12:10
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] A) {
        int max = A[0],currentSum = A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]<0){
                if(max < currentSum){
                    max = currentSum;
                }
            }
            if(currentSum<0){
                currentSum = 0;
            }
            currentSum += A[i];
        }
        if(max < currentSum){
            max = currentSum;
        }
        return max;
    }
}
