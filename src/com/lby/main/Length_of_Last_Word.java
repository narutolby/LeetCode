package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-21
 * Time: 下午5:24
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example,
 * Given s = "Hello World",
 * return 5.
 */
public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length();
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)==' ' && i!=len-1){
                return len-i-1;
            }
        }
        return len;
    }
}
