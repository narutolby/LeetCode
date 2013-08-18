package com.lby.main;

import java.util.ArrayList;

/*
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class Merge_Intervals {
	/**
	 * @param intervals
	 * @return
	 */
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Interval> li = new ArrayList<Interval>();
		int count = 0;
		for (Interval i : intervals) {
			if (i.start == 0 && i.end == 0) {
				li.add(i);
				continue;
			}
			if (count == 0) {
				list.add(i.start);
				list.add(~i.end+1);
				count += 2;
			} else {
				int start = i.start, end = i.end;
				int index = count - 1;
				while (start < Math.abs(list.get(index))
						|| start == Math.abs(list.get(index))
						&& start > list.get(index)) {
					index--;
					if(index==-1){
						break;
					}
				}
				list.add(index+1, start);
				count++;
				index = count - 1;
				while (Math.abs(end) < Math.abs(list.get(index))) {
					index--;
					if(index==-1){
						break;
					}
				}
				list.add(index+1, ~end+1);
				count++;
			}
		}
		int flag = 0;
		int start = 0,end = 0;
		for (Integer ii : list) {
			if(flag==0){
				start = ii;
			}
			if (ii >= 0) {
				flag++;
			} else {
				flag--;
			}
			if(flag==0){
				end = ii;
				Interval it = new Interval(start,~end+1);
				li.add(it);
			}
			
		}
		return li;
	}
	public static void main(String[]args){
		ArrayList<Interval>i = new ArrayList<Interval>();
		Interval i1 = new Interval(1,4);
		Interval i2 = new Interval(0,4);
		i.add(i1);
		i.add(i2);
		new Merge_Intervals().merge(i);
	}
}
