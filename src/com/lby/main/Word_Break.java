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
        return _wordBreak(s, dict, map);
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

    public static void main(String... args) {
        String s = "ab";
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        new Word_Break().wordBreak(s, set);
    }
}
