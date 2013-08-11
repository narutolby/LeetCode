package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-11
 * Time: 上午11:13
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Next_Permutation {
    public void nextPermutation(int[] num) {
         int len = num.length;
         if(len==0 || len==1) return;
         int i = len - 1;
         while(i>=1 && num[i]<=num[i-1]){
             i--;
         }
         if(i==0){
             revers(num, 0,len-1);
             return;
         }
         if(i==len-1){
            swap(num,i,i-1);
         }else{
           int j = len - 1;
           while(num[j]<num[i-1]){
               j--;
           }
            swap(num,i-1,j);
            revers(num,i,len-1);
         }

    }
    public void swap(int[]num,int i,int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    public void revers(int[]num ,int i,int j){
        while(i<j){
            swap(num,i,j);
            i++;j--;
        }
    }
}
