package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-9-15
 * Time: 上午10:05
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class Multipl_Strings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(),len2 = num2.length();
        int[] ret = new int[len1+len2];
        int start = 0;
        for(int i=len2-1;i>=0;i--){
            start = len2-i-1;
            for(int j=len1-1;j>=0;j--){
                int sum = (num2.charAt(i)-48) * (num1.charAt(j)-48) + (ret[start]);
                ret[start] = sum%10;
                ret[start+1] += sum/10;
                start++;
            }
        }
        while(start<len1+len2-1 && ret[start]>0){
            ret[start] = ret[start]%10;
            ret[start+1] += ret[start]/10;
            start++;
        }
        StringBuffer sb = new StringBuffer();
        start = len1+len2-1;
        while(ret[start]==0){
            start--;
            if(start==-1){
                sb.append(0);
                break;
            }
        }
        for(int i=start;i>=0;i--){
            sb.append(ret[i]);
        }
        return sb.toString();
    }
    public static void main(String[]args){
        System.out.println(new Multipl_Strings().multiply("0","0"));
    }
}
