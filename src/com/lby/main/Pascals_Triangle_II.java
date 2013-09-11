package com.lby.main;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-9-11
 * Time: 下午4:04
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Pascals_Triangle_II {
    public ArrayList<Integer> getRow(int rowIndex) {
        int []table = new int[rowIndex+1];
        for(int i=0;i<=rowIndex;i++){
            for(int j=i;j>=0;j--){
                if(j==0 || j==i){
                    table[j] = 1;
                }else{
                    table[j]  = table[j] + table[j-1];
                }
            }
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i=0;i<table.length;i++){
            ret.add(table[i]);
        }
        return ret;
    }
}
