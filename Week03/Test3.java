import java.util.*;

/**
 * @ClassName Testt2
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-24 21:15
 * @Version 1.0
 **/
public class Test3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + 1 + size_left_subtree, preorder_right,inorder_root + 1, inorder_right);
        return root;
    }

    //public TreeNode buildTree(int[] preorder, int[] inorder) {
    //    int n = preorder.length;
    //    // 构造哈希映射，帮助我们快速定位根节点
    //    indexMap = new HashMap<Integer, Integer>();
    //    for (int i = 0; i < n; i++) {
    //        indexMap.put(inorder[i], i);
    //    }
    //    return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    //}

    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int a = 1, b = 2, c = 3;
        for(int i = 3; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        this.generateParenthesis(res, 0, 0, n, "");
        return res;
    }

    private void generateParenthesis(List<String> res, int leftCon, int rightCon, int n, String st) {
        if(n * 2 == leftCon + rightCon){
            res.add(st);
            return;
        }
        if(leftCon < n){
            this.generateParenthesis(res, leftCon + 1, rightCon, n, st + "(");
        }
        if(rightCon < leftCon){
            this.generateParenthesis(res, leftCon, rightCon + 1, n, st + ")");
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public boolean isValidBST(TreeNode root) {
        return this.isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer leftVal, Integer rightVal) {
        if(root == null){
            return true;
        }
        int cur = root.val;
        // 当前节点 不能小于左值  左值为上一节点往右走时的根节点值
        if(leftVal != null && cur <= leftVal) return false;
        // 当前节点 不能大于右值  右值为上一节点往左走时的根节点值
        if(rightVal != null && cur >= rightVal) return false;
        // 往左走 更新右值为当前节点值
        if(!isValidBST(root.left, leftVal, cur)) return false;
        // 往右走 更新左值为当前节点值
        if(!isValidBST(root.right, cur, rightVal)) return false;

        return true;
    }

    private int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxleft = maxDepth(root.left);
        int maxright = maxDepth(root.right);
        return Math.max(maxleft + 1, maxright + 1);
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if(root.left != null){
            min = Math.min(min, minDepth(root.left));
        }
        if(root.right != null){
            min = Math.min(min, minDepth(root.right));
        }
        return min + 1;
    }

    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.lowest(root, p, q);
        return ans;
    }

    private boolean lowest(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return false;
        }
        // 当前节点的左节点是否存在目标节点
        boolean left = lowest(root.left, p, q);
        // 当前节点的右节点是否存在目标节点
        boolean right = lowest(root.right, p, q);
        if((left && right) || (root.val == p.val || root.val == q.val) && (left || right)){
            ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }

    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     */
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode resNode = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return resNode;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        // 退出递归条件
        if(preStart > preEnd){
            return null;
        }
        TreeNode cur = new TreeNode(preorder[preStart]);
        int i = map.get(preorder[preStart]);
        // 左子树个数
        int leftNodeCount = i - inStart;
        cur.left = buildTree(preorder, inorder, preStart + 1, preStart + leftNodeCount, inStart, i - 1);
        cur.right = buildTree(preorder, inorder, preStart + 1 + leftNodeCount, preEnd, i + 1, inEnd);
        // 还原当前层数据状态
        return cur;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<>(), n ,k, 1);
        return res;
    }

    private void combine(List<List<Integer>> res, List<Integer> integers, int n, int k, int fa) {
        if(integers.size() == k){
            res.add(new ArrayList<>(integers));
            return;
        }
        // 从几开始
        for(int i = fa; i <= n; i++){
            integers.add(i);
            combine(res, integers, n, k, ++fa);
            integers.remove(integers.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        this.permute(nums, res, new ArrayList<>());
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, ArrayList<Integer> integers) {
        if(nums.length == integers.size()){
            res.add(new ArrayList<>(integers));
            return;
        }
        for(int i : nums){
            if(integers.contains(i)) continue;
            integers.add(i);
            permute(nums, res, integers);
            integers.remove(integers.size() - 1);
        }
    }

    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1 || n == -1){
            return x;
        }
        double i = myPow(x, n / 2);
        double res = n % 2 == 1 ? i * i * x : i * i;
        return n < 0 ? 1 / res : res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        subsets(res, nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void subsets(List<List<Integer>> res, int[] nums, int leave, List<Integer> ints) {
        if(leave == nums.length){
            res.add(new ArrayList<>(ints));
            return;
        }
        subsets(res, nums, leave + 1, ints);
        ints.add(nums[leave]);
        subsets(res, nums, leave + 1, ints);
        ints.remove(ints.size() - 1);
    }

    private Map<Character, String> numZm = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        letterCombinations(res, 0, digits, "");
        return res;
    }

    private void letterCombinations(List<String> res, int leave, String digits, String st) {
        if(leave == digits.length()){
            res.add(st);
            return;
        }
        char c = digits.charAt(leave++);
        for(char zm : numZm.get(c).toCharArray()){
            letterCombinations(res, leave, digits, st + zm);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()){
            int len = stack.size();
            List<Integer> ints = new ArrayList<>();
            for (int i = 0; i < len; i++){
                TreeNode cur = stack.removeFirst();
                if(cur.left != null) stack.addLast(cur.left);
                if(cur.right != null) stack.addLast(cur.right);
                ints.add(cur.val);
            }
            res.add(ints);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Test3());
    }
}
