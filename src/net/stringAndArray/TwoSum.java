package net.stringAndArray;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	private Map<Integer,Integer> map = new HashMap<>();
	
	public void add(int input){
		int count = map.containsKey(input)? map.get(input) : 0;
		map.put(input, count+1);
	}
	
	public boolean find (int val){
		for (Map.Entry<Integer, Integer> entry: map.entrySet()){
			int num = entry.getKey();
			int y = val-num;
			if (y == num){
				if (entry.getValue()>=2) return true;
			}else if (map.containsKey(y))
				return true;
		
		}
		return false;
	}
	
	public void test (){
		add(1);
		add(3);
		add(5);
		System.out.println(find(4));
		System.out.println(find(7));
	}
}
