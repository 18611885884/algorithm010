import java.util.HashMap;
import java.util.Map;

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
        map = new HashMap<>();
        for(int i = 0; i < preLen; i++){
            map.put(inorder[i], i);
        }
        return buildTree(0, preLen - 1, 0, preLen - 1, preorder, inorder);
    }

    private TreeNode buildTree(int preLeft, int preRight, int inoLeft, int inoRight, int[] preorder, int[] inorder) {
        if(preLeft > preRight){
            return null;
        }
        // 获取根节点
        TreeNode root = new TreeNode(preorder[preLeft]);

        // 根节点在中序出现位置
        int rootIndex = map.get(root.val);
        // 左子树个数
        int leftNodeCount = rootIndex - inoLeft;
        root.left = buildTree(preLeft + 1, preLeft + leftNodeCount, inoLeft, rootIndex - 1, preorder, inorder);
        root.right = buildTree(preLeft + 1 + leftNodeCount, preRight, rootIndex + 1, inoRight, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        new BuildTree().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
