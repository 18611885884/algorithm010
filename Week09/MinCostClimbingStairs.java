/**
 * 746. 使用最小花费爬楼梯
 * @ClassName MinCostClimbingStairs
 * @Description
 * @Author luozhengqi
 * @Date 2020-08-18 14:37
 * @Version 1.0
 **/
public class MinCostClimbingStairs {
    /**
     * 示例 1:
     *
     * 输入: cost = [10, 15, 20]
     * 输出: 15
     * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
     *  示例 2:
     *
     * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * 输出: 6
     * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
     * 0 0 1 0
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n <= 2) return 0;
        int[] res = new int[n + 1];
        for(int i = 2; i <= n; i++){
            res[i] = Math.min(cost[i - 2] + res[i - 2], cost[i - 1] + res[i - 1]);
        }
        return res[n];
    }

    public static void main(String[] args) {
        new MinCostClimbingStairs().minCostClimbingStairs(new int[]{0,0,1,0});
    }
}
