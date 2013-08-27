package com.lby.main;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-28
 * Time: 上午1:27
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 */
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
          ArrayList<String> ret = new ArrayList<String>();
          Map<String,ArrayList<String>> map= new HashMap<String,ArrayList<String>>();
        for(String ev : strs){
            char[]chars = ev.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            if(map.containsKey(newStr)){
                map.get(newStr).add(ev);
            }else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(ev);
                map.put(newStr,list);
            }
         }
        for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()){
           if(entry.getValue().size()>1) {
               ret.addAll(entry.getValue());
           }
        }
        return ret;
    }

}

