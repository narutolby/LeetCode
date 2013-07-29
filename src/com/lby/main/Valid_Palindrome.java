package com.lby.main;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Valid_Palindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.trim().equals("")) {
			return true;
		}
        int l = 0,r = s.length()-1;
        while(l<r){
        	char left,right;
        	while(!((left=s.charAt(l))<='z' && left >='a' || left<='Z' && left>='A' || left<='9' && left>='0') && l<r){
        		l++;
        	}
        	while(!((right=s.charAt(r))<='z' && right>='a' || right<='Z' && right>='A' || right<='9' && right >='0') && r>l){
        		r--;
        	}
        	if(l>r){
        		return false;
        	}
        	char lc = s.charAt(l),rc = s.charAt(r);
        	if(lc-rc!=0 && Math.abs(lc-rc)!=32){
        		return false;
        	}else{
        		l++;r--;
        	}
        }
        return true;
	}
}
