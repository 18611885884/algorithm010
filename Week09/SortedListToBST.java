import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * @ClassName SortedListToBST
 * @Description
 * @Author luozhengqi
 * @Date 2020-08-18 12:11
 * @Version 1.0
 **/
public class SortedListToBST {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if(left == right){
            return null;
        }
        ListNode midNode = getMidTreeNode(left, right);
        TreeNode res = new TreeNode(midNode.val);
        res.left = buildTree(left, midNode);
        res.right = buildTree(midNode.next, right);
        return res;
    }

    private ListNode getMidTreeNode(ListNode left, ListNode right) {
        ListNode first = left;
        ListNode slow = left;
        while (first != right && first.next != right){
            first = first.next;
            first = first.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        new SortedListToBST().sortedListToBST(n1);
    }
}
