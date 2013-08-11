package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-11
 * Time: 下午3:33
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class Permutation_Sequence {
    private int[]table;
    private int[]num = new int[9];
    {
       table = new int[10];
       table[0] = 1;
       for(int i=1;i<=9;i++){
           table[i] = table[i-1]*i;
       }
    }
    public String getPermutation(int n, int k) {
         k = k % table[n]==0 ? table[n] : k % table[n];
         for(int i=0;i<n;i++){
             num[i] = i+1;
         }
         for(int i=1;i<k;i++){
             nextPermutation(num,0,n-1);
         }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(num[i]);
        }
        return sb.toString();
    }
    public void nextPermutation(int[] num,int s ,int e) {
        int len = e-s+1;
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
