package com.lby.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-9-11
 * Time: 下午5:10
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class Gray_Code {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(n==0){
            return list;
        }
        StringBuilder buffer = new StringBuilder();
        for(int i=0;i<n;i++){
            buffer.append(0);
        }
        Set<String> set = new HashSet<String>();
        String bs = buffer.toString();
        set.add(bs);
        list.add(Integer.valueOf(bs, 2));
        int count = (int) Math.pow(2, n);

        for (int i = count - 1; i >= 0; i--) {
            for(int j=n-1;j>=0;j--){
                char oldC =buffer.charAt(j);
                char newC = (char)((oldC-47)%2+48);
                buffer.setCharAt(j,newC);
                bs = buffer.toString();
                if(set.contains(bs)){
                    buffer.setCharAt(j,oldC);
                }else{
                    set.add(bs);
                    list.add(Integer.valueOf(bs,2));
                    break;
                }
            }
        }
        return list;
    }
    public static void main(String[]args){
        new Gray_Code().grayCode(1);
    }
}
