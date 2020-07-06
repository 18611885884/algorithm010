import java.util.Arrays;

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
        int minVal = Integer.MAX_VALUE;
        int total = 1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        while (total <= amount){
            minVal = Integer.MAX_VALUE;
            for(int i:coins){
                int diff = total - i;
                if(diff > 0 && dp[diff] > 0 || diff == 0){
                    minVal = Math.min(minVal, dp[diff] + 1);
                }
            }
            dp[total++] = (minVal == Integer.MAX_VALUE ? -1 : minVal);
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        new CoinChange().coinChange(new int[]{1,2,5}, 11);
    }
}
