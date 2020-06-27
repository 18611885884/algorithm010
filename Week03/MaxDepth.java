import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *    [104]二叉树的最大深度
 *
 * @ClassName MaxDepth
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-25 22:39
 * @Version 1.0
 **/
public class MaxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth1(TreeNode root) {
        if(root == null){
        return 0;
    }
    List<Integer> leas = new ArrayList<>();
    int n = 1;
    maxDepth(root, leas, n);
    Object[] sortMax = leas.toArray();
        Arrays.sort(sortMax);
        return (int)sortMax[sortMax.length - 1];
}

    private void maxDepth(TreeNode root, List<Integer> leas, int n) {
        if(root.left == null && root.right == null){
            leas.add(n);
            return ;
        }
        n++;
        if(root.left != null){
            maxDepth(root.left, leas, n);
        }
        if(root.right != null){
            maxDepth(root.right, leas, n);
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leMax = maxDepth(root.left);
        int riMax = maxDepth(root.right);
        return Math.max(leMax, riMax) + 1;
    }

    public static void main(String[] args) {

    }
}
