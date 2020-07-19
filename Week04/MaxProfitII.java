/**
 *      [122]买卖股票的最佳时机 II
 * @ClassName MaxProfit
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-06 12:45
 * @Version 1.0
 **/
public class MaxProfitII {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int lr = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i + 1] - prices[i] > 0){
                lr += prices[i + 1] - prices[i];
            }
        }
        return lr;
    }
}
