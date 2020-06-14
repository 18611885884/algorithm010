/**
 * 两两交换链表中的节点
 *
 * @ClassName SwapPairs
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-14 17:16
 * @Version 1.0
 **/
public class SwapPairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 一张图 解决问题 注意临界点处理
     */
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode temp = res;
        while (temp.next != null && temp.next.next != null){
            ListNode sta = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            sta.next = end.next;
            end.next = sta;
            temp = sta;
        }
        return res.next;
    }
}
