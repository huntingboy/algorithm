package com.nomad.leetcode;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) { //evaluate-reverse-polish-notation
        if (tokens != null) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                } else if (tokens[i].equals("-")) {
                    stack.push(-(stack.pop() - stack.pop()));
                } else if (tokens[i].equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else if (tokens[i].equals("/")) {
                    int tmp = stack.pop();
                    stack.push(stack.pop() / tmp);
                } else {
                    stack.push(Integer.valueOf(tokens[i]));
                }
            }
            return stack.pop();
        }
        return 0;
    }
}
