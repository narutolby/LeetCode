package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-21
 * Time: 下午7:30
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */
public class Implement_strStr {
    public String strStr(String haystack, String needle) {
       int len = haystack.length(),len2 = needle.length();
       for(int i=0;i+len2<len;i++){
          int j = 0;
          for(;j<len2 && i+j<len && haystack.charAt(i+j) == needle.charAt(j);j++){}
          if(j==len2){
             return haystack.substring(i);
          }
       }
        if(len ==0 && len2==0){
            return "";
        }
        return null;

    }
}
