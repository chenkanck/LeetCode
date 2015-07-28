package net.DPandBacktrack;
import java.util.*;

public class WordBreakII {
	//BackTracking TLE
	private Set<String> dict;
    public List<String> wordBreak1(String s, Set<String> wordDict) {
        this.dict = wordDict;
        StringBuilder sb = new StringBuilder();
        helper(s,0,sb);
        return rst;
    }
    
    public void helper(String s, int pos, StringBuilder sb){
        if (pos == s.length()){
            rst.add(sb.toString());
            return;
        }
        for (int i=pos; i<s.length();i++){
            String sub = s.substring(pos,i+1);
            if (dict.contains(sub)){
                StringBuilder copy = new StringBuilder(sb);
                if (copy.length() > 0)
                    copy.append(" ");
                copy.append(sub);
                helper(s,i+1,copy);
            }
        }
    }
    
    
    ArrayList<String> rst = new ArrayList<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp,false);
        /*
         * check dp[i], if true, use dict to calculate dp[i+len] will be faster
         */
        for (int i=0;i<s.length();i++){
            for (String word : wordDict){
                int len = word.length();
                if (len <= i+1 && (i-len == -1 || dp[i-len])){
                    //check the subtring is the word
                    if (word.equals(s.substring(i+1-len, i+1))){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        //build strings
        
        if (!dp[s.length()-1]) return rst;
        return helper(dp,s,wordDict,0);
    }
    
    public List<String> helper(boolean[] dp, String s,Set<String> dict, int start){
        ArrayList<String> res = new ArrayList<>();
        for (int i=start; i<s.length();i++){
            if (dp[i] && dict.contains(s.substring(start,i+1))){
                
            	List<String> tails = helper(dp,s,dict, i+1);
                String head = s.substring(start,i+1);
                if (i==s.length()-1) 
                	res.add(head);
                else{
                	for (String tail : tails){
                    	res.add(head+" "+tail);
                	}
                }
            }
        }
        return res;
    }
}

class Test {
	public static void main (String[] args){
		WordBreakII t = new WordBreakII();
		
		Set<String> set = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		String s = "catsanddog";
		long begin = System.currentTimeMillis();
		List<String> rst = t.wordBreak1(s, set);
		long end1 = System.currentTimeMillis();
		List<String> rst2 = t.wordBreak(s, set);
		long end2 = System.currentTimeMillis();
		System.out.println("BackTrack:\t"+(end1 - begin));
		System.out.println("DP\t"+(end2 - end1));
		for (String a:rst){
			System.out.println(a);
		}
	}
}
