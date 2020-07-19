import java.util.*;

/**
 *    [105]从前序与中序遍历序列构造二叉树
 *
 * @ClassName BuildTree
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-30 23:42
 * @Version 1.0
 **/
public class BuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        // 记录当前（根）节点在中序中的位置区分左右节点
        map = new HashMap<>();
        for(int i = 0; i < preLen; i++){
            map.put(inorder[i], i);
        }
        return buildTree(0, preLen - 1, 0, preLen - 1, preorder, inorder);
    }

    /**
     * @param preLeft 前序左边界
     * @param preRight 前序右边界
     * @param inoLeft 中序左边界
     * @param inoRight 中序右边界
     * @param preorder 前序数组
     * @param inorder 中序数组
     */
    private TreeNode buildTree(int preLeft, int preRight, int inoLeft, int inoRight, int[] preorder, int[] inorder) {
        if(preLeft > preRight){
            return null;
        }
        // 获取根节点
        TreeNode root = new TreeNode(preorder[preLeft]);
        // 根节点在中序出现位置
        int rootIndex = map.get(root.val);
        // 左子树（节点）个数
        int leftNodeCount = rootIndex - inoLeft;
        root.left = buildTree(preLeft + 1, preLeft + leftNodeCount, inoLeft, rootIndex - 1, preorder, inorder);
        root.right = buildTree(preLeft + 1 + leftNodeCount, preRight, rootIndex + 1, inoRight, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        new BuildTree().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
