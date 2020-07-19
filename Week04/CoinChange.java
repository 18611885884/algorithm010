/**
 *    [322]零钱兑换
 *
 * @ClassName CoinChange
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-06 06:48
 * @Version 1.0
 **/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        int total = 1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        while (total <= amount){
            int minVal = Integer.MAX_VALUE;
            for(int i:coins){
                // 当前钱减去钱袋中每个值 的差额
                int diff = total - i;
                // 差额所处的位置 兑换需要的最小次数  + 1  或者当前金额本身在钱袋中有
                if((diff > 0 && dp[diff] > 0) || diff == 0){
                    minVal = Math.min(minVal, dp[diff] + 1);
                }
            }
            // 更新当前钱兑换需要的最小次数
            dp[total++] = (minVal == Integer.MAX_VALUE ? -1 : minVal);
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        new CoinChange1().coinChange(new int[]{1,2,5}, 11);
    }
}
