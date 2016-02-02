package datastructure;

import java.util.Stack;

/* 
 * http://www.lintcode.com/zh-cn/problem/implement-queue-by-two-stacks/
 */

public class ImplementQueueByStacks {
	private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueueByStacks() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }            
        }
        return stack2.peek();
    }
}
