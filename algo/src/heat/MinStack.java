package heat;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-14 10:28
 */
public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minValStack;


    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        s.getMin();
        s.pop();
        s.top();
        s.getMin();
    }

    public MinStack() {
        stack = new LinkedList<>();
        minValStack = new LinkedList<>();
        minValStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minValStack.push(Math.min(minValStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minValStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValStack.peek();
    }

    public void showInfo(String msg){

    }
}
