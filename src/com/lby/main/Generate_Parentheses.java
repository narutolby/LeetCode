package com.lby.main;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-9
 * Time: 上午12:44
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Generate_Parentheses {
    public ArrayList<String> generateParenthesis(int n) {
        int diff= 0;
        ArrayList<String> list = new ArrayList<String>();
        generateParenthesis(n,n,list,diff,"");
        return list;
    }
    public void generateParenthesis(int left,int right,ArrayList<String> list,int diff,String pre) {
       if(left==0 && right==0){
           list.add(pre);
           return;
       }
       if(diff==0) {
          pre = pre + "(";
          diff++;left--;
          generateParenthesis(left,right,list,diff,pre);
          return;
       }
       if(diff>0){
          if(left>0) {
              diff++;left--;
              generateParenthesis(left,right,list,diff,pre+"(");
              diff--;left++;
          }
          if(right>0){
              diff--;right--;
              generateParenthesis(left,right,list,diff,pre+")");
          }
       }
    }
}
