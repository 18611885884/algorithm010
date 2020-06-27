/**
 *    [111]二叉树的最小深度
 *
 * @ClassName MinDepth
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-27 21:31
 * @Version 1.0
 **/
public class MinDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 方法一  递归
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null){
            min = Math.min(min, minDepth(root.left));
        }
        if(root.right != null){
            min = Math.min(min, minDepth(root.right));
        }
        return min + 1;
    }
}
