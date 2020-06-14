import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName QueueTest
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-14 21:08
 * @Version 1.0
 **/
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        System.out.println(queue); // 1234
        String polledElement = queue.poll();
        System.out.println(polledElement); // 1
        System.out.println(queue); // 234
        String peekedElement = queue.peek();
        System.out.println(peekedElement); // 2
        System.out.println(queue); // 234
        while(queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }
}
