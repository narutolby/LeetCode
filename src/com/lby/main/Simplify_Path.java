package com.lby.main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-25
 * Time: 上午10:52
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class Simplify_Path {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();
        String aws = "/",combin="";
        String[]paths = path.split("/");
        for(int i=0;i<paths.length;i++){
            String drive = paths[i].trim();
            if(drive.equals("") || drive.equals(".")){
               continue;
            }
           if(drive.equals("..")) {
               if(stack.size()==0){
                   continue;
               }
               stack.pop();
           }else{
               stack.push(drive);
           }
        }
        boolean flag = false;
        while(!stack.isEmpty()){
           String ev = stack.pop();
           if(flag){
               ev += "/";
           }
            flag = true;
           combin = ev + combin;
        }
        return aws+combin;
    }
    public static void main(String[]args){
        new Simplify_Path().simplifyPath("/home/fool");
    }
}
