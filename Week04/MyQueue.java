import java.util.Stack;

/**
 *    [232]用栈实现队列
 * @ClassName MyQueue
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-01 12:25
 * @Version 1.0
 **/
public class MyQueue {

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.push(1);
        mq.push(2);
    }

    /**
     * 测试用例:["MyQueue","push","push","peek","pop","empty"]
     * 			[[],[1],[2],[],[],[]]
     * 			测试结果:[null,null,null,2,2,true]
     * 			期望结果:[null,null,null,1,1,false]
     */

    Stack<Integer> zStack;
    Stack<Integer> fStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        zStack = new Stack<>();
        fStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        zStack.push(x);
        fStack = new Stack<>();
        for(int i = zStack.size() - 1; i >= 0; i--){
            fStack.push(zStack.elementAt(i));
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res = fStack.pop();
        zStack = new Stack<>();
        for(int i = fStack.size() - 1; i >= 0; i--){
            zStack.push(fStack.elementAt(i));
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        return fStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return fStack.empty();
    }
}
