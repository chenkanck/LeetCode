package net.kc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class YodleTriangle {
	/*
	 * Read the triangle for txt file
	 * return: data structure storing the triangle
	 */
	public static List<List<Integer>> readTriangle (String fileLocation){
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		try {
			File file = new File(fileLocation);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			while (line != null){
				String[] numbers = line.split(" ");
				ArrayList<Integer> lineNums = new ArrayList<Integer>();
				for (String s: numbers){
					lineNums.add(Integer.parseInt(s));
				}
				result.add(lineNums);
				line = br.readLine();
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	/*
	 * find the maximum total
	 */
	public static int triangle (List<List<Integer>> triangle) {
		if (triangle == null || triangle.size()==0)
			return 0;
		List<Integer> maxline = new ArrayList<Integer>();
		maxline.add(triangle.get(0).get(0));
		for (int h=1 ; h<triangle.size(); h++){
			List<Integer> currentLine = triangle.get(h);
			maxline.add(0, Integer.MIN_VALUE);
			int i;
			for (i= 0; i < h;i++){
				maxline.set(i, currentLine.get(i)+Math.max(maxline.get(i), maxline.get(i+1)));
			}
			maxline.set(i, currentLine.get(i)+maxline.get(i));
		}
		int result = Integer.MIN_VALUE;
		for (Integer n: maxline){
			result = Math.max(n, result);
		}
		return result;
	}

	public static void main(String[] args){
		String fileLoc = "/Users/Modoka/Desktop/Yodle/triangle.txt";
		List<List<Integer>> rst = readTriangle(fileLoc);
		System.out.println("Result:" + String.valueOf(triangle(rst)));
	}
	
	
}
