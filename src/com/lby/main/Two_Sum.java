package com.lby.main;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-30
 * Time: 下午10:05
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Two_Sum {
    public int[] twoSum(int[] numbers, int target) {
        int[]ret = new int[2];
        int begin = 0,end = numbers.length-1;
        Arrays.sort(numbers);
        while(begin<=end){
           int first = numbers[begin],second = numbers[end];
           if(first + second == target) {
               ret[0] = first;
               ret[1] = second;
           }else if(first + second < target){
               begin++;
           }else{
               end--;
           }
        }
        return ret;
    }
}
