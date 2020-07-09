/**
 * 21. 合并两个有序链表
 * @ClassName MergeTwoLists
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-08 22:57
 * @Version 1.0
 **/
public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode ls = res;
        while (l1 != null || l2 != null){
            if(l1 == null || (l2 != null && l1.val > l2.val)){
                ls.next = l2;
                l2 = l2.next;
            }else {
                ls.next = l1;
                l1 = l1.next;
            }
            ls = ls.next;
        }
        return res.next;
    }
}
