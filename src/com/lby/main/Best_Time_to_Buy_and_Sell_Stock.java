package com.lby.main;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
		if(prices.length==0){
			return 0;
		}
        int min = prices[0],max = 0;
        for(int i=0;i<prices.length;i++){
        	if(min>prices[i]){
        		min = prices[i];
        	}
        	if(prices[i]-min > max){
        		max = prices[i]-min;
        	}
        }
        return max;
    }
}
