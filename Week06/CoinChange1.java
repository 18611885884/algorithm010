/**
 * 322. 零钱兑换
 * @ClassName CoinChange
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-17 23:37
 * @Version 1.0
 **/
public class CoinChange1 {

    /**
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     * 示例 2:
     *
     * 输入: coins = [2], amount = 3
     * 输出: -1
     */
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                int diff = i - coin;
                if((diff > 0 && res[diff] > 0) || diff == 0){
                    min = Math.min(min, res[diff]);
                }
            }
            res[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }
        return res[amount];
    }

    public static void main(String[] args) {
        new CoinChange1().coinChange(new int[]{1,2,5}, 11);
    }
}
