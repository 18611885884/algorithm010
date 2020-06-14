import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 * @ClassName HasCycle
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-14 17:47
 * @Version 1.0
 **/
public class HasCycle {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 方法一  利用HashSet数据结构判断是否有重复
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> res = new HashSet<>();
        while (head != null){
            if(res.contains(head)){
                return true;
            }
            res.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 方法二  快慢指针
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode mNode = head;
        ListNode kNode = head.next;
        while (mNode != kNode){
            if(kNode == null || kNode.next == null){
                return false;
            }
            mNode = mNode.next;
            kNode = kNode.next.next;
        }
        return true;
    }
}
