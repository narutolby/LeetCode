package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-21
 * Time: 上午9:45
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class Add_Binary {
    public String addBinary(String a, String b) {
        StringBuilder aws = new StringBuilder();
        int l1 = a.length(),l2 = b.length(),pre = 0;
        int i = 0;
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        for(;i<l1 && i<l2;i++){
            int v1 = Character.valueOf(a.charAt(i))-48,v2 = Character.valueOf(b.charAt(i))-48;
            int sum = v1 + v2 + pre;
            pre = sum / 2;
            aws.append(sum % 2);
        }
        while(i<l1){
            int sum = Character.valueOf(a.charAt(i))+pre-48;
            aws.append(sum % 2);
            pre = sum / 2;
            i++;
        }
        while(i<l2){
            int sum = Character.valueOf(b.charAt(i))+pre-48;
            aws.append(sum % 2);
            pre = sum / 2;
            i++;
        }
        if(pre!=0){
            aws.append(pre);
        }
        aws.reverse();
        return aws.toString();
    }
}
