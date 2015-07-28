package net.kc;

public class DP {
	public static void main(String[] args){
		testMatch();
	}
	
	public static boolean isMatch(String s, String p) {
        return matchHelper(s,0,p,0);
    }
    public static boolean matchHelper(String s, int sl,String p, int pl){
        if (pl==p.length())
            return sl==s.length();
        if (p.charAt(pl)=='*'){
            while(sl<=s.length()){
                if (matchHelper(s,sl,p,pl+1))
                    return true;
                sl++;
            }
        }else if(sl==s.length()){
            return false;
        }else if (p.charAt(pl)!='?'&&p.charAt(pl)!=s.charAt(sl)){
            return false;
        }else{
            return matchHelper(s,sl+1,p,pl+1);
        }
        return false;
    }
    public static boolean isMatchDP(String s, String p) {
        if (s==null||p==null)
            return false;
        if (p.length()==0)
            return s.length()==0;
        if (s.length()==0){
            for (int i=0;i<p.length();i++)
                if (p.charAt(i)!='*') return false;
            return true;
        }
        //s.len and p.len != 0
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        for (int i=1;i<=s.length();i++)//no pattern but has string
            dp[0][i] = false;
        for (int i=1;i<=p.length();i++){
            if (p.charAt(i-1)=='*')
                dp[i][0] = true;
            else
                break;
        }
        for (int i=1;i<=p.length();i++){
            for (int j=1;j<=s.length();j++){
                if (!dp[i-1][j-1]) break;
                if (p.charAt(i-1)=='*'){
                    for(int k=j;k<s.length();k++)
                        dp[i][k] = dp[i-1][j-1];
                    break;
                }else if(p.charAt(i-1)=='?'||p.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        
        return dp[p.length()][s.length()];
    }
    public static void testMatch(){
//    	isMatch("aa","a") → false
//    	isMatch("aa","aa") → true
//    	isMatch("aaa","aa") → false
//    	isMatch("aa", "*") → true
//    	isMatch("aa", "a*") → true
//    	isMatch("ab", "?*") → true
//    	isMatch("aab", "c*a*b") → false
    	System.out.println(isMatchDP("ab","a"));
    	System.out.println(isMatchDP("ab","ab"));
    	System.out.println(isMatchDP("aba","ab"));
    	System.out.println(isMatchDP("ab","*"));
    	System.out.println(isMatchDP("ab","a*"));
    	System.out.println(isMatchDP("ab","?*"));
    	System.out.println(isMatchDP("aab","c*a*b"));
    	System.out.println(isMatchDP("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba","a*******b"));
    }
}
