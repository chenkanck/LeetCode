package net.stringAndArray;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
	public static List<String> findMissingRanges(int[] vals, int start, int end){
		List<String> ranges = new ArrayList<>();
		int pre = start - 1 ;
		for (int i=0; i<=vals.length ; i++){
			int value = i==vals.length? end+1 :vals[i];
			if (value > pre + 1)
				ranges.add(makeRange(pre+1, value-1));
			pre = value;
		}
		return ranges;
	}
	
	private static String makeRange(int start, int end){
		return start==end? String.valueOf(start) : start + "->" + end;
	}
	
	public static void main(String[] args){
		List<String> rst = findMissingRanges(new int[] {0,1,3,50,75}, 0,99);
		for (String s : rst){
			System.out.println(s);
		}
	}
}
