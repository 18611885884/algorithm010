/**
 * 121. 买卖股票的最佳时机
 * @ClassName MaxProfit
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-19 00:22
 * @Version 1.0
 **/
public class MaxProfit {
    /**
     * [7,1,5,3,6,4]
     * 输出: 5
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     */
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int res = 0;
        int mr = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > mr){
                res = Math.max(res, prices[i] - mr);
            }else{
                mr = prices[i];
            }
        }
        return res;
    }
}
