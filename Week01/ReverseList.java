/**
 * 反转链表
 *
 * @ClassName ReverseList
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-14 15:14
 * @Version 1.0
 **/
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 迭代 1、暂存当前节点下一节点后续节点内容
     *      2、下一节点指向上一节点（pre）
     *      3、上一节点更新为当前节点
     *      4、当前节点更新为暂存后续节点
     *
     *      总结：双向节点的好处
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            ListNode temNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temNext;
        }

        return pre;
    }

    public ListNode reverseList1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
