import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *    [95]不同的二叉搜索树 II
 * @ClassName GenerateTrees
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-21 15:09
 * @Version 1.0
 **/
public class GenerateTrees {

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

    /**
     * 方法一 递归
     * 解题思路：循环每个值(i)充当根节点
     * i的左右部分就是 左节点和右节点可以存在的情况，
     * 汇总出左右的情况（子问题） 两两组合得出所有可能的情况
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        // 递归终止条件  start > end
        if(start > end){
            result.add(null);
            return result;
        }
        // 递归终止条件  start = end  只有一个值，只能是根节点
        if(start == end){
            TreeNode treeNode = new TreeNode(start);
            result.add(treeNode);
            return result;
        }
        // 循环每个值(i)充当根节点
        for(int i = start; i <= end; i++){
            // i 的左部分
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for(TreeNode leftNode : lefts){
                for(TreeNode rightNode : rights){
                    // 根节点
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new GenerateTrees().generateTrees(5);
    }
}
