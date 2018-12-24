package com.feng.stack;

import java.util.Stack;

/**
 * 括号匹配
 * @author: PMTY
 * @create: 2018-12-24 16:51
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isVaild("([{}])"));
    }

    public static boolean isVaild(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty())
                    return false;
                Character topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}