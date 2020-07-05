import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *    [102]二叉树的层序遍历
 *
 * @ClassName LevelOrder1
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-02 00:50
 * @Version 1.0
 **/
public class LevelOrder1 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodes = queue.size();
            List<Integer> ceng = new ArrayList<>();
            for(int i = 0; i < nodes; i++){
                TreeNode cur = queue.removeFirst();
                ceng.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            res.add(ceng);
        }
        return res;
    }
}
