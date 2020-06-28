/**
 *    [236]二叉树的最近公共祖先
 *
 * @ClassName LowestCommonAncestor
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-28 22:19
 * @Version 1.0
 **/
public class LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        // left && right 在条分支上，公共祖节点不是 p 或 q
        // root.val == p.val || root.val == q.val 公共节点是 p 或者 q 的情况
        if((left && right) || (root.val == p.val || root.val == q.val) && (left || right)){
            ans = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }
}
