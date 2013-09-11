package com.lby.main;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-9-11
 * Time: 下午3:38
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Pascals_Triangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> rootList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i ) {
                    list.add(j, 1);
                }else{
                    list.add(j,rootList.get(i-1).get(j)+rootList.get(i-1).get(j-1));
                }
            }
            rootList.add(list);
        }
        return rootList;
    }
    public static void main(String[]args){
        new Pascals_Triangle().generate(4);
    }
}
