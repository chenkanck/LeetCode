package net.kc;

import java.util.List;

public class Intervals {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null)
            return intervals;
        if (intervals.size()<1){
            intervals.add(newInterval);
            return intervals;
        }
        //binary search start
        int lo = 0;
        int hi = intervals.size()-1;
        int mid, left, right;
        while (lo<hi){
            mid = (lo+hi)/2;
            if (newInterval.start == intervals.get(mid).end){
                lo=mid;
                break;
            }else if (newInterval.start < intervals.get(mid).end){
                hi = mid;
            }else
                lo=mid+1;
        }
        left=lo;
        //binary search end
        lo =0;
        hi = intervals.size()-1;
        while (lo<hi){
            mid = (lo+hi)/2;
            if (newInterval.end == intervals.get(mid).start){
                lo = mid+1;
                break;
            }else if (newInterval.end > intervals.get(mid).start)
                lo = mid+1;
            else
                hi = mid;
        }
        right = lo-1;
        //
        if (right >= left){
            int startBound, endBound;
            startBound = Math.min(newInterval.start, intervals.get(left).start);
            endBound = Math.max(newInterval.end, intervals.get(right).end);
            Interval insert = new Interval(startBound,endBound);
            for (int i=left; i<= right; i++)
                intervals.remove(left);
            intervals.add(left, insert);
        }else if (right !=-1){
            
            intervals.add(left, newInterval);
        }else {
            if (newInterval.end< intervals.get(0).start){
                intervals.add(0, newInterval);
            }else if (newInterval.start > intervals.get(0).end){
                intervals.add(1, newInterval);
            }else {
            int startBound, endBound;
            startBound = Math.min(newInterval.start, intervals.get(0).start);
            endBound = Math.max(newInterval.end, intervals.get(0).end);
            Interval insert = new Interval(startBound,endBound);
            intervals.remove(0);
            intervals.add(0, insert);
            }
        }
        
        
        return intervals;
    }
	
	
	 public class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	 }
}
