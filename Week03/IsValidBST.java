import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *   [98]验证二叉搜索树
 *
 * @ClassName IsValidBST
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-27 15:12
 * @Version 1.0
 **/
public class IsValidBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 方法一 中序遍历，迭代
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 关键点 注意范围使用
        double vi = - Double.MAX_VALUE;
        while (!stack.empty() || root != null){
            while (root != null){
                // 栈先进后出，依次放入根节点（左）
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 中序 递增
            if(root.val <= vi) return false;
            vi = root.val;
            // 左根处理完  处理右节点
            root = root.right;
        }
        return true;
    }

    // 方法二 递归
    public boolean isValidBST1(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer leftVal, Integer rightVal) {
        if(root == null){
            return true;
        }
        int cur = root.val;
        if(leftVal != null && cur <= leftVal) return false;
        if(rightVal != null && cur >= rightVal) return false;

        if(!helper(root.left, cur, rightVal)) return false;
        if(!helper(root.right, leftVal, cur)) return false;
        return true;
    }
}
