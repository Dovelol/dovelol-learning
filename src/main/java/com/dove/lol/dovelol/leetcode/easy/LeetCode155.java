package com.dove.lol.dovelol.leetcode.easy;

import java.util.Stack;

/**
 * @author Dovelol
 * @date 2021/4/10 23:58
 */
public class LeetCode155 {

    private Stack<Integer>  s1;

    private Stack<Integer> s2;

    /** initialize your data structure here. */
    public LeetCode155() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int val) {
        if(s1.empty()){
            s2.push(val);
        }else {
            int top = s2.peek();
            if(val <= top){
                s2.push(val);
            }
        }
        s1.push(val);
    }

    public void pop() {
        if(s2.empty()){
            return;
        }
        int top = s1.peek();
        if(top == s2.peek()){
            s2.pop();
        }
            s1.pop();
    }

    public Integer top() {
        if(s1.empty()){
            return null;
        }
        return s1.peek();
    }

    public Integer getMin() {
        if(s2.empty()){
            return null;
        }
        return s1.peek();
    }

    public static void main(String[] args) {
        LeetCode155 minStack = new LeetCode155();
        minStack.getMin();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        minStack.getMin();
        minStack.top();
        minStack.top();
        minStack.getMin();
    }

}
