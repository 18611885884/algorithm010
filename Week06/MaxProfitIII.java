/**
 * 123. 买卖股票的最佳时机 III
 * @ClassName MaxProfitIII
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-19 00:57
 * @Version 1.0
 **/
public class MaxProfitIII {
    /**
     * 1.状态：0，未交易，1，买入一次，2卖出1次，3买入2次，4卖出2次
     *      dp[i][j] 用户手上金钱
     * 2. DP公式
     *      - dp[i][0] = dp[i-1][0]
     *      - dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
     *      - dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
     *      - dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
     *      - dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
     *
     * 方法一 二维数组
     */
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int n = prices.length;
        int[][] res = new int[n][5];
        res[0][0] = 0;
        res[0][1] = -prices[0];
        res[0][2] = 0;
        res[0][3] = -prices[0];
        res[0][4] = 0;
        for(int i = 1; i < n; i++){
            res[i][0] = 0;
            res[i][1] = Math.max(res[i - 1][1], res[i - 1][0] - prices[i]);
            res[i][2] = Math.max(res[i - 1][2], prices[i] + res[i - 1][1]);
            res[i][3] = Math.max(res[i - 1][3], res[i - 1][2] - prices[i]);
            res[i][4] = Math.max(res[i - 1][4], prices[i] + res[i - 1][3]);
        }
        return Math.max(res[n - 1][2], res[n - 1][4]);
    }

    /**
     * 1.状态：0，未交易，1，买入一次，2卖出1次，3买入2次，4卖出2次
     * 方法二 二维数组优化 一位数组
     */
    public int maxProfit1(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[] res = new int[5];
        res[0] = 0;
        res[1] = -prices[0];
        res[2] = 0;
        res[3] = -prices[0];
        res[4] = 0;
        for(int i = 1; i < n; i++){
            int a = res[1], b = res[2], c = res[3], d = res[4];
            res[1] = Math.max(a, res[0] - prices[i]);
            res[2] = Math.max(b, a + prices[i]);
            res[3] = Math.max(c, b - prices[i]);
            res[4] = Math.max(d, c + prices[i]);
        }

        return Math.max(res[2], res[4]);
    }
}
