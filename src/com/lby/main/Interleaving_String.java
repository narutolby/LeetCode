package com.lby.main;

import java.util.Arrays;

/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */
public class Interleaving_String {
//	public boolean isInterleave(String s1, String s2, String s3) {
//		 int[] cache = new int[s3.length()];
//		 Arrays.fill(cache, 0);
//		 int l3 = s3.length(),l2 = s2.length() ,l1 = s1.length();
//		 if(l1+l2!=l3){
//			 return false;
//		 }
//		 int j=0;
//		 for(int i=0;i<l3 && l1!=0;i++){
//			 char c = s3.charAt(i);
//			 if(c==s1.charAt(j)){
//				 cache[i] = 1;
//				 j++;
//				 if(j==s1.length()){
//					 break;
//				 }
//			 }
//		 }
//		 if(j!=s1.length()) {
//			 return false;
//		 }
//		 j = 0;
//		 for(int i=0;i<l3 && l2!=0;i++){
//			 if(cache[i]==1){
//				 continue;
//			 }else{
//				 char c = s3.charAt(i);
//				 if(c!=s2.charAt(j)){
//					 return false;
//				 }
//                 j++;				 
//                 if(j==s2.length()){
//                	 break;
//                 }
//			 }
//		 }
//		 if(j!=s2.length()){
//			 return false;
//		 }
//         return true;
//		
//	}
	public boolean isInterleave(String s1, String s2, String s3) {
	    if(s3.length()!=s1.length() + s2.length())	{
	    	return false;
	    }else{
	    	return isInterleave(s1,s1.length(),s2,s2.length(),s3,s3.length());
	    }
	}
	public boolean isInterleave(String s1,int l1,String s2,int l2,String s3,int l3){
		if(l3==0){
			return true;
		}
		if(l1==0){
			if(s2.substring(0, l2).equals(s3.substring(0, l3))){
				return true;
			}else{
				return false;
			}
		}
		if(l2==0){
			if(s1.substring(0, l1).equals(s3.substring(0, l3))){
				return true;
			}else{
				return false;
			}
		}
		if(s1.charAt(l1-1)==s2.charAt(l2-1) && s1.charAt(l1-1)==s3.charAt(l3-1)){
			  return isInterleave(s1,l1-1,s2,l2,s3,l3-1) || isInterleave(s1,l1,s2,l2-1,s3,l3-1);
		}
		if(s1.charAt(l1-1) == s3.charAt(l3-1)){
			return isInterleave(s1,l1-1,s2,l2,s3,l3-1);
		}
		if(s2.charAt(l2-1) == s3.charAt(l3-1)){
			return isInterleave(s1,l1,s2,l2-1,s3,l3-1);
		}
		return false;
	}
	public static void main(String[]args){
		String name = "a";
		System.out.println(name.substring(0,1));
	}
}
