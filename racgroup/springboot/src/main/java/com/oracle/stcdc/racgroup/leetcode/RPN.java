package com.oracle.stcdc.racgroup.leetcode;

import java.util.Stack;

/**
 * 第 150 号问题：逆波兰表达式求值
 */
public class RPN {


    public static int evalRPN(String[] str){

        int rc = -1;

        Stack<Integer> stack = new Stack<>();

        for (String s : str) {

            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){

                int num1 = stack.pop();
                int num2 = stack.pop();

                if(s.equals("+")){
                    rc = num2 + num1;
                }else  if(s.equals("-")){
                    rc = num2 - num1;
                }else if(s.equals("*")){
                    rc = num2 * num1;
                }else{
                    rc = num2 / num1;
                }

                stack.push(rc);

            }else{
                stack.push(Integer.parseInt(s));

            }
        }

        return rc;

    }


    public static void main(String[] args) {
        String[] str = new String[]{"2", "1", "+", "3", "*"};
        String[] str1 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(str));
        System.out.println(evalRPN(str1));
    }
}
