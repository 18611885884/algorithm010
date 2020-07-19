/**
 * 714. 买卖股票的最佳时机含手续费
 * @ClassName MaxProfitSXF
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-19 21:28
 * @Version 1.0
 **/
public class MaxProfitSXF {
    /**
     * 方法一  状态定义  0  不交易  1 持有股票  2 抛售股票   可已优化，0 和 2 本质相同
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        int res[][] = new int[n][3];
        res[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            res[i][0] = Math.max(res[i - 1][0], res[i - 1][1]);
            res[i][1] = Math.max(Math.max(res[i - 1][0] - prices[i], res[i - 1][2] - prices[i]), res[i - 1][1]);
            if(prices[i] - prices[i - 1] > fee){
                res[i][2] = Math.max(res[i - 1][1] + prices[i] - fee, res[i - 1][2]);
            }else{
                res[i][2] = res[i - 1][2];
            }
        }
        return Math.max(Math.max(res[n - 1][0], res[n - 1][1]), res[n - 1][2]);
    }

    /**
     * 方法二  两个状态解决  cash 不持股票最大利润  hold 持有股票最大利润
     */
    public int maxProfit1(int[] prices, int fee) {
        if(prices.length == 0){
            return 0;
        }
        int cash = 0, hold = - prices[0];
        for(int i = 1; i < prices.length; i++){
            cash = Math.max(cash, hold + prices[i] -fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfitSXF().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
