package com.lby.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Word_Ladder {
	public static int ladderLength(String start, String end,
			HashSet<String> dict) {
		int num = dfs(start, end, dict);
		return (num == Integer.MAX_VALUE ? 0 : num);
	}

	/**
	 * dfs小数据测试通过，大数据测试不过，需要用bfs来优化
	 * 
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	public static int dfs(String start, String end, HashSet<String> dict) {
		if (start.equals(end)) {
			return 1;
		}
		int min = Integer.MAX_VALUE;
		int len = start.length();
		String tmpS = start;
		for (int i = 0; i < len; i++) {
			char[] arr = start.toCharArray();
			for (char j = 'a'; j <= 'z'; j++) {
				if (j == start.charAt(i)) {
					continue;
				}
				arr[i] = j;
				start = new String(arr);
				if (!dict.contains(start)) {
					continue;
				}
				dict.remove(start);
				int tmp = dfs(start, end, dict);
				dict.add(start);
				if (tmp == Integer.MAX_VALUE) {
					continue;
				}
				min = Math.min(min, 1 + tmp);
			}
			start = tmpS;
		}
		return min;
	}

	/**
	 * 本题用bfs优化
	 * 
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	public static int bfs(String start, String end, HashSet<String> dict) {
		class myEn{
			String name;
			int  level;
			myEn(String name,int level){
               this.name = name;
               this.level = level;
			}
		}
		int len = start.length();
		Queue<myEn> queue = new LinkedList<myEn>();
		queue.offer(new myEn(start,1));
		dict.remove(start);
		while (!queue.isEmpty()) {
			myEn word = queue.poll();
			int lev = word.level;
			char[] arr = word.name.toCharArray();
			for (int i = 0; i < len; i++) {
				char tmp = arr[i];
				for (char j = 'a'; j <= 'z'; j++) {
					if (j == tmp) {
						continue;
					}
					arr[i] = j;
					word = new myEn(new String(arr),lev+1);
					if (word.name.equals(end)) {
						return lev+1;
					}
					if (!dict.contains(word.name)) {
						continue;
					}
					dict.remove(word.name);
					queue.offer(word);
				}
				arr[i] = tmp;
			}
		}
		return 0;
	}
	public static void main(String[]args){
		HashSet<String> set = new HashSet<String>();
	    set.add("hot");
	    set.add("cog");
	    set.add("dot");
	    set.add("dog");
	    set.add("hit");
	    set.add("lot");
	    set.add("log");
	    int m = bfs("hit","cog",set);
	    System.out.println(m);
	}
}
