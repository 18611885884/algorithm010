/**
 * 226. 翻转二叉树
 *
 * @ClassName InvertTree
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-27 12:02
 * @Version 1.0
 **/
public class InvertTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode lsNode = null;
        if(root.left != null || root.right != null){
            lsNode = root.right;
            root.right = root.left;
            root.left = lsNode;
        }
        invertTree(root.left);
        invertTree(root.right);
        lsNode = null;
        return root;
    }
}
