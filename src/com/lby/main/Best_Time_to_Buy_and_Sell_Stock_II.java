package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-8-18
 * Time: 下午9:55
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int len = prices.length, aws = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                aws += prices[i] - prices[i - 1];
            }
        }
        return aws;
    }
}
