package com.lby.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-10-5
 * Time: 下午11:49
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */

public class Word_Break {
    /*递归方式实现，最后一个大数据不过，尝试采用dp*/
    public boolean wordBreak(String s, Set<String> dict) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (String str : dict) {
            int len = str.length();
            if (map.containsKey(len)) {
                map.put(len, map.get(len) + 1);
            } else {
                map.put(len, 1);
            }
        }
        return __wordBreak(s, dict, map);
    }

    public boolean _wordBreak(String s, Set<String> dict, Map<Integer, Integer> map) {
        if (dict.contains(s)) {
            return true;
        }
        int len = s.length();
        boolean ret = false;
        for (int i = 1; i <= len; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            String str = s.substring(0, i);
            if (dict.contains(str)) {
                if (i == len) {
                    return true;
                }
                ret = wordBreak(s.substring(i, len), dict);
                if (ret) {
                    return ret;
                }
            }
        }
        return false;
    }
    /************************************************************************************/
    /*dp大数据通过*/
    public boolean __wordBreak(String s,Set<String> dict,Map<Integer,Integer> map){
        int len = s.length();
        if(len<2){
            if(dict.contains(s)){
                return true;
            }
        }
        boolean []dp = new boolean[len];
        dp[0] = dict.contains(String.valueOf(s.charAt(0)));
        for(int i=1;i<len;i++) {
            dp[i] = dict.contains(s.substring(0,i+1));
            if(dp[i]){
                continue;
            }
            for(int j=i-1;j>=0;j--){
                if(dp[j] && dict.contains(s.substring(j+1,i+1))){
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[len-1];
    }
}
