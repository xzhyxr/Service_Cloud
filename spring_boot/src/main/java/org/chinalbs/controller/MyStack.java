package org.chinalbs.controller;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	List<Integer> myStack;

    /** Initialize your data structure here. */
    public MyStack() {
    	myStack = new ArrayList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	myStack.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return myStack.remove(myStack.size() - 1);
    }
    
    /** Get the top element. */
    public int top() {
    	return myStack.get(myStack.size() - 1);
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return myStack.isEmpty();
    }
}
