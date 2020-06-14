import java.util.Stack;

/**
 * @ClassName Stack
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-14 21:03
 * @Version 1.0
 **/
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack); // 1234
        System.out.println(stack.search(4)); // 1
        stack.pop(); // 4
        stack.pop(); // 3
        Integer topElement = stack.peek(); // 2
        System.out.println(topElement);
        System.out.println(" 3的位置 " + stack.search(3)); // -1
    }
}
