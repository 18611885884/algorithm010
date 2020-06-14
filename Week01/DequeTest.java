import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName DequeTest
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-14 21:10
 * @Version 1.0
 **/
public class DequeTest {

    public static void main(String[] args) {

        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque); // cba
        String str = deque.peek(); // c
        System.out.println(str); // c
        System.out.println(deque); // cba
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);// []


        Deque<String> dequeNew = new LinkedList<String>();
        dequeNew.addFirst("a");
        dequeNew.addFirst("b");
        dequeNew.addFirst("c");
        dequeNew.addLast("d");
        System.out.println(dequeNew); // cbad
        boolean rfe = dequeNew.removeFirstOccurrence("e");
        System.out.println(rfe); // false
        boolean rfb = dequeNew.removeFirstOccurrence("b");
        System.out.println(rfb); // true
        System.out.println(dequeNew); // cad
        dequeNew.removeFirst();
        System.out.println(dequeNew); // ad
    }
}
