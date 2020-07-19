/**
 *
 * @ClassName MaxProfitIV
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-19 18:58
 * @Version 1.0
 **/
public class MaxProfitIV {

    /**
     * 示例 1:
     *
     * 输入: [2,4,1], k = 2
     * 输出: 2
     * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     * 示例 2:
     *
     * 输入: [3,2,6,5,0,3], k = 2
     * 输出: 7
     * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
     */

    public static void main(String[] args) {
        new MaxProfitIV().maxProfit(2, new int[]{3,2,6,5,0,3,4});
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        if(n / 2 <= k){
            int resVal = 0;
            for(int i = 1; i < n; i++){
                if(prices[i] - prices[i - 1] > 0){
                    resVal += prices[i] - prices[i - 1];
                }
            }
            return resVal;
        }
        int[][] res = new int[k + 1][n];
        for(int i = 1; i <= k; i++){
            int localMax = res[i - 1][0] - prices[0];
            for(int j = 1; j < n; j++){
                res[i][j] = Math.max(res[i][j - 1], localMax + prices[j]);
                localMax = Math.max(localMax, res[i - 1][j] - prices[j]);
            }
        }
        return res[k][n - 1];
    }
}
