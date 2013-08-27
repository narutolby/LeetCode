package com.lby.main;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-25
 * Time: 下午8:54
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Thanks Marcos for contributing this image!
 */
public class Trapping_Rain_Water {
    public int trap(int[] A) {
       int len = A.length;
       if(len==0) return 0;
       LinkedList<Integer> stack = new LinkedList<Integer>();
       int i = 0;
       while(A[i]==0){
           i++;
       }
       stack.push(A[i]);
       for(;i<len;i++) {
          if(A[i]<stack.peekLast()){
              stack.push(A[i]);
          }else{

          }
       }
       return 0;
    }
}
