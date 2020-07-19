import java.util.*;

/**
 * @ClassName Test4
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-02 00:24
 * @Version 1.0
 **/
public class Test4 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        List<TreeNode> chs;
        TreeNode(int x) { val = x; }
    }

    public void depthFirstSearch(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        // 处理节点信息
        for(TreeNode ch:treeNode.chs){
            depthFirstSearch(ch);
        }
    }

    public void broadFirstSearch(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            for(TreeNode ch:cur.chs){
                queue.add(ch);
            }
        }
    }

    public int coinChange(int[] coins, int amount) {
        int min = Integer.MAX_VALUE;
        // 填充dp数组的索引  1 到 amount
        int total = 1;
        // 记录每个金额可以实现要求的最小值，处理过的数据缓存起来，从金额为1开始处理
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        while (total <= amount) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int diff = total - coins[i];
                if (diff > 0 && dp[diff] > 0 || diff == 0) {
                    min = Math.min(min, dp[diff] + 1);
                }
            }
            dp[total++] = (min == Integer.MAX_VALUE ? -1 : min);
        }
        return dp[amount];
    }

    public TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.foseerqs(root, p, q);
        return this.ans;
    }

    private boolean foseerqs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return false;
        }
        boolean left = foseerqs(root.left, p, q);
        boolean right = foseerqs(root.right, p, q);
        if((left && right) || (root.val == p.val || root.val == q.val) && (left || right)){
            ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        return 0;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = nums.length - 1; j > i + 2; j--){
                if(j < nums.length - 1 && nums[j] == nums[j + 1]) continue;
                int m = i + 1, n = j - 1;
                int sumTar = target - nums[i] - nums[j];
                while (m < n){
                    int sum = nums[m] + nums[n];
                    if(sum == sumTar){
                        res.add(Arrays.asList(nums[i], nums[m], nums[n], nums[j]));
                        while (m < n && nums[m] == nums[++m]);
                        while (m < n && nums[n] == nums[--n]);
                    }else if(sum < sumTar){
                        while (m < n && nums[m] == nums[++m]);
                    }else{
                        while (m < n && nums[n] == nums[--n]);
                    }
                }
            }

        }
        return res;
    }

    public int jump(int[] nums) {
        // 跳跃可到达结束位置
        int end = 0;
        // 再到达结束位置之前可达到最远位置
        int maxIndex = 0;
        int jumpCon = 0;
        for(int i = 0; i < nums.length - 1; i++){
            // 记录最原位置
            maxIndex = Math.max(maxIndex, i + nums[i]);
            // 到达上一次最远位置，更新下一次位置
            if(i == end){
                end = maxIndex;
                jumpCon++;
            }
        }
        return jumpCon;
    }

    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        long i = 0, j = x / 2;
        while (i <= j){
            long mid = i + (j - i) / 2;
            long pf = mid * mid;
            if(pf <= x && ((mid + 1) * (mid + 1) > x)){
                return (int)mid;
            }else if(pf < x){
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Test4().jump(new int[]{2,3,1,1,4}));
    }
}
