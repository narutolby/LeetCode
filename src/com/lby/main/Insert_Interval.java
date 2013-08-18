package com.lby.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class Insert_Interval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Interval> ans = new ArrayList<Interval>();
		if (newInterval.start == newInterval.end && newInterval.start == 0) {
			ans.add(newInterval);
			newInterval = null;
		}
//		} else {
//			list.add(newInterval.start);
//			list.add(~newInterval.end + 1);
//		}
		if(intervals.size()!=0){
			Interval i = intervals.get(0);
			if(i.start==i.end && i.start ==0){
				ans.add(i);
				intervals.remove(0);
			}
		}
        if(newInterval!=null && intervals.size()!=0){
        	int x=0,y=0,z=0;
        	ArrayList<Integer> f1 = new ArrayList<Integer>();
        	f1.add(newInterval.start);
        	f1.add(~newInterval.end+1);
        	ArrayList<Integer> f2 = new ArrayList<Integer>();
        	for(int i=0;i<intervals.size();i++){
        		f2.add(intervals.get(i).start);
        		f2.add(~intervals.get(i).end+1);
        	}
        	while(x<2 && y<f2.size()){
        		 int fv1 = f1.get(x),fv2 = f2.get(y);
        		 if(Math.abs(fv1)<Math.abs(fv2)  ){
        			 x++;
        		 }else if(Math.abs(fv1)>Math.abs(fv2)){
        			 y++;
        		 }
        		 z++;
        	}
        }
		int count = 0, start = 0, end = 0;
		for (int n = 0; n < list.size(); n++) {
			Integer i = list.get(n);
			if (count == 0) {
				start = i;
			}
			if (i >= 0) {
				count++;
			}
			if (i < 0) {
				count--;
			}
			if (count == 0) {
				end = i;
				Interval it = new Interval(start, ~end + 1);
				ans.add(it);
			}
		}
		return ans;
	}
	
}
