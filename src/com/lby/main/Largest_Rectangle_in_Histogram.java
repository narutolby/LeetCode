package com.lby.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-10-6
 * Time: 下午1:50
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class Largest_Rectangle_in_Histogram {
    /*最后一个大数据不通过，尝试新的方法*/
    public int largestRectangleArea(int[] height) {
        int len = height.length;

        if (len == 0) {
            return 0;
        }
        int ret = 0, min = 0;
        for (int i = 0; i < len; i++) {
            min = height[i];
            if (min == 0) {
                continue;
            }
            for (int j = i; j < len; j++) {
                min = Math.min(min, height[j]);
                ret = Math.max(ret, min * (j - i + 1));
            }
        }
        return ret;
    }

    /*
        int largestRectArea(vector<int>&h) {
            stack<int> p;
            int i = 0, m = 0;
            h.push_back(0);
            while (i < h.size()) {
                if (p.empty() || h[p.top()] <= h[i])
                    p.push(i++);
                else {
                    int t = p.top();
                    p.pop();
                    m = max(m, h[t] * (p.empty() ? i : i - p.top() - 1));
                }
            }
            return m;
        }
    */
    /*根据discussion里面的解法仿照写的，o(n)时间复杂度，难度有点大*/
    /*好难*/
    public int _largestRectangleArea(int[] height) {
        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int[] tmpHeight = new int[len + 1];
        System.arraycopy(height, 0, tmpHeight, 0, len);
        Stack<Integer> stack = new Stack<Integer>();
        tmpHeight[len] = 0;
        height = tmpHeight;
        int i = 0, max = 0;
        while (i <= len) {
            if (stack.empty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int j = stack.pop();

                max = Math.max(max, (stack.empty() ? i : (i - stack.peek() - 1)) * height[j]);
            }
        }

        return max;
    }
}

