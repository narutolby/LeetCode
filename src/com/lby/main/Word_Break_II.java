package com.lby.main;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-10-8
 * Time: 上午12:28
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class Word_Break_II {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        if(s==null || s.length()==0) {
            return ret;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(String str : dict){
            set.add(str.length());
        }
        LinkedList<String> buff = new LinkedList<String>();
        __wordBreak(s,dict,set,buff,ret);

        return ret;

    }
    public boolean __wordBreak(String s,Set<String> dict,Set<Integer> set,LinkedList<String> buff,ArrayList<String>ret){
        int len = s.length();
        boolean checked = false;
        for(int length : set){
           if(length>len){
               continue;
           }
           String subStr = s.substring(0,length);
           if(dict.contains(subStr)){
               if(length==len){
                  StringBuilder sb = new StringBuilder();
                  for(String str : buff){
                      sb.append(str).append(" ");
                  }
                  ret.add(sb.toString().trim());
                  return true;
               }
               buff.add(subStr);
               checked = __wordBreak(s.substring(length),dict,set,buff,ret);
               buff.removeLast();
           }
        }
        return checked;
    }
}
