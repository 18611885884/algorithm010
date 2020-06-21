import java.util.ArrayList;
import java.util.List;

/**
 * N查叉树 后序遍历
 *
 * @ClassName PostOrder
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-20 21:38
 * @Version 1.0
 **/
public class PostOrder {

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

    List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if(root != null && root.children != null){
            for(int i = 0; i < root.children.size(); i++){
                postorder(root.children.get(i));
            }
            result.add(root.val);
        }
        return result;
    }
}
