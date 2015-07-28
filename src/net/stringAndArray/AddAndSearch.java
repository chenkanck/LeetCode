package net.stringAndArray;

public class AddAndSearch {
	    class TrieNode {
	        // 26 is '#' means end of a word
	        TrieNode[] children;
	        Character val;
	        TrieNode( Character ch){
	            this.val = ch;
	            this.children = new TrieNode[27];
	        } 
	    }
	    
	    private TrieNode root = new TrieNode('@');
	    // Adds a word into the data structure.
	    public void addWord(String word) {
	        TrieNode cur = root;
	        for (int i = 0; i<word.length();i++){
	            char ch = word.charAt(i);
	            int rank = ch - 'a';
	            if (cur.children[rank] == null){
	                //new and add
	                cur.children[rank] = new TrieNode(ch);
	            }
	            cur = cur.children[rank];
	        }
	        TrieNode end = new TrieNode('#');
	        cur.children[26] = end;
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean searchsub(String word, TrieNode cur) {
	        
	        for (int i=0; i<word.length();i++){
	            if (word.charAt(i) == '.'){
	                //backtracking
	                for (int k=0;k<=26;k++){
	                    if ((cur.children[k] != null)&& searchsub(word.substring(i+1), cur.children[k])){
	                        return true;
	                    }
	                }
	                return false;
	            }else if (cur.children[word.charAt(i)-'a'] == null)
	                return false;
	            else
	                cur = cur.children[word.charAt(i) - 'a'];
	        }
	        return cur.children[26] != null;
	    }
	    
	    public boolean search(String word){
	        TrieNode cur = root;
	        return searchsub(word,root);
	    }
	

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
}
