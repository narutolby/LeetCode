package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-9-19
 * Time: 下午3:08
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Best_Time_to_Buy_and_Sell_Stock_III {
    /*
     * 小数据通过，大数据不过
     */
    public int maxProfit(int[] prices) {
        int len = prices.length, max = Integer.MIN_VALUE;
        if (len < 2) {
            return 0;
        }
        int leftMin = prices[0],left = 0;
        for (int i = 1; i < len; i++) {
             if(left<prices[i]-leftMin){
                 left = prices[i] - leftMin;
             }
            if(leftMin>prices[i]){
                leftMin = prices[i];
            }
            int right = _maxProfit(prices, i + 1, len - 1, len);
            int tmpMax = 0;
            if (left >= 0 && right >= 0) {
                tmpMax = left + right;
            } else if (left >= 0) {
                tmpMax = left;
            } else if (right >= 0) {
                tmpMax = right;
            } else{
                tmpMax = 0;
            }
            if(tmpMax>max){
                max = tmpMax;
            }
        }
        return max;

    }

    public int _maxProfit(int[] prices, int start, int end, int len) {
        if (start >= len || start >= end) {
            return 0;
        }
        int max = Integer.MIN_VALUE, min = prices[start];
        for (int i = start + 1; i <= end; i++) {
            if (max < prices[i] - min) {
                max = prices[i] - min;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return max;
    }
    //*******************************************************************
    /*
     * 大数据测试通过
     */

    public int _maxProfit(int[] prices){
        int max = 0,len = prices.length;
        if(len<=1){
            return max;
        }
        int[]history = new int[len],future = new int[len];
        int l = prices[0],r = prices[len-1];
        for(int i=1;i<len;i++){
            history[i] = Math.max(history[i-1],prices[i]-l);
            l = Math.min(l,prices[i]);
        }
        for(int i=len-2;i>=0;i--){
            future[i] = Math.max(future[i+1],r-prices[i]);
            r = Math.max(r,prices[i]);
            int tmp = 0;
            if(i>0){
                tmp = history[i-1];
            }
            max = Math.max(max,tmp+future[i]);
        }
        return max;
    }
}
