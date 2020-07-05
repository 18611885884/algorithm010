import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 *
 * @ClassName LargestValues
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-02 01:13
 * @Version 1.0
 **/
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodes = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for(int i = 0; i < nodes; i++){
                TreeNode cur = queue.removeFirst();
                maxValue = Math.max(maxValue, cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            res.add(maxValue);
        }
        return res;
    }
}
