package com.lby.main;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-11
 * Time: 下午11:16
 * Given a number represented as an array of digits, plus one to the number.
 */
public class Plus_One {
    public int[] plusOne(int[] digits) {
       int len = digits.length,i = len-1;
       int [] res =  null;
       while ((++digits[i])>=10){
          digits[i] -= 10;
          if(i==0){
             res = new int[len+1] ;
             res[0] = 1;
              for(int j=0;j<len;j++){
                  res[j+1] = digits[j];
              }
             break;
          }
          i--;
       }
       if(res!=null){
           return res;
       }
        return digits;
    }
}
