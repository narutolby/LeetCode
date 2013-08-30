package com.lby.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<=end;i++){
            if(map.containsKey(numbers[i])){
                map.get(numbers[i]).add(i+1);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i+1);
                map.put(numbers[i],list);
            }
        }
        Arrays.sort(numbers);
        while(begin<=end){
           int first = numbers[begin],second = numbers[end];
           if(first + second == target) {
               ret[0] = map.get(first).remove(0);
               ret[1] = map.get(second).remove(0);
               Arrays.sort(ret);
               break;
           }else if(first + second < target){
               begin++;
           }else{
               end--;
           }
        }
        return ret;
    }
}
