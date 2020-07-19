/**
 * 309. 最佳买卖股票时机含冷冻期
 * @ClassName MaxProfitIIII
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-19 12:31
 * @Version 1.0
 **/
public class MaxProfitL {
    /**
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     */
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int n = prices.length;
        // 0 冷冻期 最大收益  1 持股最大收益  2 不持股最大收益
        int[][] res = new int[n][3];
        res[0][0] = 0;
        res[0][1] = -prices[0];
        res[0][2] = 0;
        for(int i = 1; i < n; i++){
            res[i][0] = Math.max(res[i - 1][0], res[i - 1][2]);
            res[i][1] = Math.max(res[i - 1][0] - prices[i], res[i - 1][1]);
            res[i][2] = Math.max(res[i - 1][2], res[i - 1][1] + prices[i]);
        }
        return Math.max(Math.max(res[n - 1][0], res[n - 1][1]), res[n - 1][2]);
    }

    /**
     * 方法二  优化状态定义
     *  f[i][0]: 手上持有股票的最大收益
     *  f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
     *  f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
     */
}
