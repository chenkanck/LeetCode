package net.stringAndArray;

import java.util.HashMap;
import java.util.Map;

public class MaxPoint {
	class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
	public int maxPoints(Point[] points) {
        if (points == null || points.length==0) return 0;
        if (points.length<= 2) return points.length;
        int max = 0;
        for (int i=0; i<points.length;i++){
            Point A = points[i];
            Map<Double, Integer> count = new HashMap<>();
            int duplicate = 1;
            for (int j=i+1; j<points.length;j++){
                Point B = points[j];
                int x = A.x-B.x;
                int y = A.y-B.y;
                if (x==0 && y==0) {
                    duplicate++;
                    continue;
                }
                double a;
                if (x==0){
                    a = Double.MAX_VALUE;
                }else{
                    a = (double)y/x;
                }
                if (count.containsKey(a))
                    count.put(a, count.get(a)+1);
                else
                    count.put(a,1);
            }
            
            for (Map.Entry<Double,Integer> entry: count.entrySet()){
                max = Math.max(max, entry.getValue() + duplicate);
            }
        }
        return max;
    }
	public void test(){
		Point[] points = {new Point(2,3), new Point(3,3), new Point(-5,3)};
		System.out.println(maxPoints(points));
	}
}
