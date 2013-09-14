package com.lby.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-9-14
 * Time: 下午9:05
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class _3Sum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> rootList = new ArrayList<ArrayList<Integer>>();
        Set<String> set = new HashSet<String>();
        StringBuffer sb = new StringBuffer();
        if(len < 3){
           return rootList;
        }
        Arrays.sort(num);
        for(int i=0;i<len;i++){
            int key = 0 - num[i];
            if(key<num[0])continue;
            int l = 0,r = len-1;
            while(l<r){
               if(l==i){
                  l++;
                  continue;
               }
               if(r==i){
                   r--;
                   continue;
               }
              if(num[r]+num[l]<key){
                  l++;
              }else if(num[r]+num[l]>key){
                  r--;
              }else{
                  ArrayList<Integer> list = new ArrayList<Integer>();
                  int key1 = 0 - key;
                  sb.setLength(0);
                  list.add(num[l]);
                  list.add(num[r]);
                  //System.out.println(key1);
                  if(key1 < num[l]){
                      list.add(0,key1);
                  }else if(key1 > num[r]){
                      list.add(key1);
                  }else{
                      list.add(1,key1);
                  }
                  for(int m=0;m<list.size();m++){
                      sb.append(list.get(m));
                  }
                  String str = sb.toString();
                  if(!set.contains(str)){
                      set.add(str);
                      rootList.add(list);
                  }
                  l++;
                  r--;
              }
            }
        }
        return rootList;
    }
    public static void main(String[]args){
        int[] a = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
           System.out.println(new _3Sum().threeSum(a));
    }
}
