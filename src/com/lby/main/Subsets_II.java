package com.lby.main; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class Subsets_II {
	 private Set<String> set = new HashSet<String>();
	 public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		 set.clear();
		 ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
         ArrayList<Integer> sub = new ArrayList<Integer>();
         list.add(sub);
         Arrays.sort(S); 
         for(int i : S){
        	 int len = list.size();
        	 for(int j=0;j<len;j++){
        		 sub= new ArrayList<Integer>();
        		 sub.addAll(list.get(j)) ;
        		 sub.add(i);
        		 String hashCode = this.getHashCode(sub);
        		 if(!set.contains(hashCode)){
        			 list.add(sub);
                     set.add(hashCode);        			 
        		 }
        	 }
         }
         return list;
    }
	 public String getHashCode(ArrayList<Integer>list){
		 Collections.sort(list);
		 StringBuilder sb = new StringBuilder(); 
		 for(Integer i : list){
			 sb.append(i);
		 }
		 return sb.toString();
	 }
	 public static void main(String[]args){
		 int[]array = {1,2};
		 for(int i:array){
			 System.out.println(i);
		 }
	 }
}
