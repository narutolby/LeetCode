package com.lby.main;

import java.util.HashMap;
import java.util.Map;
/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *For example,
 *Given [100, 4, 200, 1, 3, 2],
 *The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *Your algorithm should run in O(n) complexity.
 */
public class Longest_Consecutive_Sequence {

	public static int longestConsecutive(int[] num) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 1;
		for (int i : num) {
			if (map.containsKey(i)) {
				continue;
			}
			map.put(i, 1);
			if (map.containsKey(i + 1)) {
				max = Math.max(max,merge(map, i, i + 1));
			}
			if (map.containsKey(i - 1)) {
				max=Math.max(max,merge(map, i - 1, i));
			}
		}
		return max;
	}

	public static int merge(Map<Integer, Integer> map, int left, int right) {
		int higher = left + map.get(right);
		int lower = left - map.get(left) + 1;
		int len = higher - lower + 1;
		map.put(higher, len);
		map.put(lower, len);
		return len;
	}

	public static void main(String[] args) {
		int[] array = new int[10];
		array[-1] = 0;
	}
}
