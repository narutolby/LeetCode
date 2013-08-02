package com.lby.main;

/*
 *Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 Have you thought about this?
 Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
 */
public class Reverse_Integer {
	public int reverse(int x) {
		boolean neg = false;
		if (x < 0) {
			neg = true;
			x = Math.abs(x);
		}
		int y = 0;
		while (x > 0) {
          y = y*10+x%10;
          x = x/10;
		}
		if(y<0){
			return -1;
		}
		if(neg){
			return ~y+1;
		}else{
			return y;
		}
	}
}
