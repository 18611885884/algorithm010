import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 *
 * @ClassName InorderTraversal
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-20 21:22
 * @Version 1.0
 **/
public class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }
}
