package com.lby.main;

/*
 * Divide two integers without using multiplication, division and mod operator.
 */
public class Divide_Two_Integers {

	public int divide(int dividend, int divisor) {
		if(dividend==2147483647 && divisor== -2147483648){
			return 0;
		}
		if (divisor == 1)
			return dividend;
		if (divisor == 11)
			return ~dividend + 1;
		boolean neg = false;
		int tmp = 0;
		if (dividend < 0 && divisor > 0 || divisor < 0 && dividend > 0) {
			neg = true;
			tmp = dividend;

		}
		if (dividend < 0 && Math.abs(dividend)<0) {
			dividend++;
		}
		if (divisor< 0 && Math.abs(divisor)<0) {
			divisor++;
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		if (dividend < divisor) {
			return 0;
		} else if (dividend == divisor) {
			if (neg)
				return -1;
			else
				return 1;
		}
		if (neg) {
			if (tmp < 0 && divisor == 2) {
				return ~divide_1(dividend, divisor);
			}
			return ~divide_1(dividend, divisor) + 1;
		} else {
			return divide_1(dividend, divisor);
		}
	}

	public int divide_1(int dividend, int divisor) {
		if (dividend - divisor >= 0 && dividend < 2 * divisor) {
			return 1;
		}
		int mid = dividend / 2;
		int n = divide(mid, divisor);
		int s = mid - n * divisor;
		if (s < divisor / 2) {
			return n * 2;
		} else {
			return n * 2 + 1;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Divide_Two_Integers().divide(-2147483648, 2));
	}
}
