import java.util.Stack;

/**
 * 最小栈
 *
 * @ClassName MinStack
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-14 23:12
 * @Version 1.0
 **/
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        if(minStack.peek().equals(stack.pop())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
