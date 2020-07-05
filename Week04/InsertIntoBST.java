/**
 * 701. 二叉搜索树中的插入操作
 *
 * @ClassName InsertIntoBST
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-02 23:14
 * @Version 1.0
 **/
public class InsertIntoBST {

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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(val > root.val){
            insertIntoBST(root.right, val);
        }
        insertIntoBST(root.left, val);
        return root;
    }
}
