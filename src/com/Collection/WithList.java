package com.Collection;

import java.util.List;

public class WithList {
	public static <T> void reverse(List<T> list){
		int l= 0;
		int r= list.size()-1;
		while (l < r){
			T tmp = list.get(l);
			list.set(l, list.get(r));
			list.set(r, tmp);
			l++;
			r--;
		}
	}
}
