package net.stringAndArray;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int i=0;
        StringBuilder sb = new StringBuilder();
        while (i<path.length()){
            if (path.charAt(i) == '/'){
                if (sb.length() == 0)
                    break;
                else if (sb.toString() == ".."){
                    if (!stack.isEmpty()) stack.pop();
                }else if (sb.toString() != "."){
                    stack.push(sb.toString());
                }
                sb.delete(0,sb.length());
                    
            }else{
                sb.append(path.charAt(i));
            }
            i++;
        }
        if (sb.length()!=0) stack.push(sb.toString());
        
        sb.delete(0,sb.length());
        while (!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        if (sb.length()==0) sb.append("/");
        return sb.toString();
    }
}
