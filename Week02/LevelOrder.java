import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 *
 * @ClassName LevelOrder
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-22 00:40
 * @Version 1.0
 **/
public class LevelOrder {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     *
     * 返回其层序遍历:
     *
     * [
     *      [1],
     *      [3,2,4],
     *      [5,6]
     * ]
     */

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()){
            List<Integer> chList = new ArrayList<>();
            int len = que.size();
            for(int i = 0; i < len; i++){
                Node chNo = que.poll();
                chList.add(chNo.val);
                que.addAll(chNo.children);
            }
            res.add(chList);
        }
        return res;
    }
}
