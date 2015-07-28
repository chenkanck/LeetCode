package net.stringAndArray;

import java.util.*;

public class PostfixEvak {
	private static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("+","-","*","/"));
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s: tokens){
            if (!OPERATORS.contains(s)){
                int operand = Integer.parseInt(s);
                stack.push(operand);
            }else{
                int a = stack.pop();
                int b = stack.pop();
                stack.push(eval(a,b,s));
            }
        }
        return stack.pop();
    }
    public int eval (int a, int b, String op){
        switch(op){
            case "+": return a+b;
            case "*": return a*b;
            case "-": return b-a;
            case "/": return b/a;
            default: return 0;
        }
    }
    
    interface Operator {
    	int eval(int x,int y);
    }
    
    private static final Map<String, Operator> map = new HashMap<String,Operator>() {{
    	put("+", new Operator() {
    		public int eval(int x,int y) 
    		{return x+y;}
    	});
    	
    }};
}
