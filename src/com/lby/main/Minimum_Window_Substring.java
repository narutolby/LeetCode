package com.lby.main;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-23
 * Time: 下午3:26
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Minimum_Window_Substring {
    public String minWindow(String S, String T) {
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE ,count = 0,tlen= T.length(),slen = S.length();
        int minDif = Integer.MAX_VALUE;
        String aws = "";
        HashMap <Character,Integer> map = new HashMap<Character,Integer>();
        HashMap <Character,Queue<Integer>> mq = new HashMap<Character,Queue<Integer>>();
        for(int i=0;i<tlen;i++){
            char c = T.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        for(int i=0;i<slen;i++){
           char c = S.charAt(i);
           if(map.containsKey(c)){
               if(mq.containsKey(c)) {
                   if(map.get(c) > mq.get(c).size()){
                       count++;
                   }else{
                       mq.get(c).poll();
                   }
                   mq.get(c).offer(i);
               }else{
                   Queue<Integer> queue = new LinkedList<Integer>();
                   queue.offer(i);
                   mq.put(c,queue);
                   count++;
               }
           }else{
               continue;
           }
            if(count == tlen){
                   min = Integer.MAX_VALUE;max = Integer.MIN_VALUE;
                   for(Map.Entry<Character,Queue<Integer>> entry :mq.entrySet()){
                       Queue q = entry.getValue();
                       Iterator<Integer> iterator = q.iterator();
                       while (iterator.hasNext()){
                           int val = iterator.next();
                           if(val < min) {
                               min = val;
                           }
                           if(val > max){
                               max = val;
                           }
                       }
                   }
                   if(minDif > max - min){
                      minDif = max - min;
                      aws = S.substring(min,max+1);
                   }
            }
        }
        return aws;
    }
    public static void main(String[] args){
        String a = new Minimum_Window_Substring().minWindow("bdab","ab");
        System.out.println(a);
    }
}
