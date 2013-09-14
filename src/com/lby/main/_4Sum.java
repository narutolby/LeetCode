package com.lby.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-9-1
 * Time: 下午9:54
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
public class _4Sum {
    /*
     * 小数据测试通过，大数据不过
     */

    Set<String> set = new HashSet<String>();
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> root  = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        if(num.length<4){
            return root;
        }
        fourSum(num, target, 1, null,root,0);
        return root;
    }
    public void fourSum(int[]num,int target,int level,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> root,int start){
       if(level == 1){
           list = new ArrayList<Integer>();
       }
       int len = num.length;
       for(int i=start;i<len;i++){
           if(list.size()>=level){
               if(list.get(level-1)!=num[i]){
                   list.set(level-1,num[i]);
               }
           }else{
               list.add(num[i]);
           }
           if(level!=4){
               fourSum(num,target-num[i],level+1,list,root,i+1) ;
           }else{
              if(target == num[i]){
                 ArrayList<Integer>  subList = new ArrayList<Integer>();
                 subList.addAll(list);
                 root.add(subList);
              }
           }
       }

    }
    public static void main(String[]args){
        int[]num = {-1,2,2,-5,0,-1,4};
        System.out.println(new _4Sum()._fourSum(num, 3));
    }
    /*
     * 小数据测试通过，大数据测试通过，oye
     */

    public ArrayList<ArrayList<Integer>> _fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> rootList = new ArrayList<ArrayList<Integer>>();
        Set<String> set = new HashSet<String>();
        StringBuffer sb = new StringBuffer();
        int len = num.length;
        if(len < 4){
            return rootList;
        }
        Arrays.sort(num);
        for(int i=0;i<len-3;i++){
            for(int j=i+3;j<len;j++){
                int t = target - num[i] - num[j];
                int l = i+1,r = j-1;
                while(l<r){
                    if(num[l] + num[r] < t){
                        l++;
                    }else if(num[l] + num[r] > t){
                        r--;
                    }else{
                        sb.setLength(0);
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[l]);
                        list.add(num[r]);
                        list.add(num[j]);
                        sb.append(num[i]);
                        sb.append(num[l]);
                        sb.append(num[r]);
                        sb.append(num[j]);
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
        }
        return rootList;
    }
}
