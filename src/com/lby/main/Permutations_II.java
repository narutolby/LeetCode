package com.lby.main;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-10
 * Time: 上午1:03
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class Permutations_II {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        permute(num,0,list,new ArrayList<Integer>());
        return list;
    }
    public void permute(int[] num,int start,ArrayList<ArrayList<Integer>>list,ArrayList<Integer> subList) {
        if(start==num.length){
            list.add(subList);
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=start;i<num.length;i++){
            if(!set.contains(num[i])){
                set.add(num[i]);
            }else{
                continue;
            }
            ArrayList subList1  = new ArrayList<Integer>();
            subList1.addAll(subList);
            swap(num,start,i);
            subList1.add(num[start]);
            permute(num,start+1,list,subList1);
            swap(num,start,i);
        }
    }
    public void swap(int[]num,int i,int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
