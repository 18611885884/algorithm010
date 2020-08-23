import java.util.Arrays;

/**
 * @ClassName Test9
 * @Description
 * @Author luozhengqi
 * @Date 2020-08-12 20:21
 * @Version 1.0
 **/
public class Test9 {
    /**
     * 爬楼梯
     */
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int a = 1, b = 2, c = 3;
        for(int i = 2; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 不同路径
     */
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    res[i][j] = 1;
                    continue;
                }
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }

    /**
     * 不同路径解法二
     */
    public int uniquePaths1(int m, int n) {
        int[] res = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0){
                    res[j] = 1;
                    continue;
                }
                res[j] = res[j] + res[j - 1];
            }
        }
        return res[m - 1];
    }

    /**
     * 不同路径II
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] != 1){
                    if(i == 0 && j == 0){
                        res[i][j] = 1;
                    }else{
                        res[i][j] = (i > 0 && obstacleGrid[i - 1][j] != 1 ? res[i - 1][j] : 0) + (j > 0 && obstacleGrid[i][j - 1] != 1 ? res[i][j - 1] : 0);
                    }
                }
            }
        }
        return res[m - 1][n - 1];
    }

    /**
     * 198. 打家劫舍
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        int[] res = new int[n];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
        }
        return res[n - 1];
    }

    /**
     * 最小路径和
     */
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i > 0) left = grid[i - 1][j];
                if(j > 0) up = grid[i][j - 1];
                grid[i][j] = grid[i][j] + Math.min(left, up);
            }
        }
        return grid[n - 1][m - 1];
    }

    /**
     * 买卖股票的最佳时机
     */
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int res = 0, mr = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > mr){
                res = Math.max(prices[i] - mr, res);
            }else{
                mr = Math.min(prices[i], mr);
            }
        }
        return res;
    }

    /**
     * 买卖股票的最佳时机II
     */
    public int maxProfitII(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        int res = 0;
        for(int i = 1; i < n; i++){
            if(prices[i] > prices[i - 1]){
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    /**
     * 买卖股票的最佳时机III
     * 0 不持有  1 第一次买入  2 第一次卖出  3 第二次买入  4 第二次卖出
     */
    public int maxProfitIII(int[] prices) {
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

    /**
     * 309. 最佳买卖股票时机含冷冻期
     *
     */
    public int maxProfit5(int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] res = new int[n][3];
        res[0][0] = -prices[0];
        for(int i = 1; i < n; i++){
            res[i][0] = Math.max(res[i - 1][0], res[i - 1][2] - prices[i]);
            res[i][1] = res[i - 1][0] + prices[i];
            res[i][2] = Math.max(res[i - 1][2], res[i - 1][1]);
        }
        return Math.max(res[n - 1][1], res[n - 1][2]);
    }

    public int maxProfit1(int[] prices, int fee) {
        int n = prices.length;
        if(n < 2) return 0;
        int cash = 0, hig = -prices[0];
        for(int i = 1; i < n; i++){
            cash = Math.max(cash, hig + prices[i] - fee);
            hig = Math.max(hig, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        int res = 0;
        int i = 0;
        for(; res <= 699; i++){
            res += Math.pow(2, i);
        }
        System.out.println(Math.pow(2, i));
    }

    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int[] res = new int[n + 1];
        res[n] = 1;
        res[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
        for(int i = n - 2; i >=0; i--){
            if(s.charAt(i) == '0'){
                continue;
            }else {
                res[i] = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? res[i + 1] + res[i + 2] : res[i + 1];
            }
        }
        return res[0];
    }

    /**
     * 示例 1:
     *
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     * 示例 2:
     *
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     *
     * ()((())
     * 输出: 4
     * 012345
     * ()(())
     * 输出: 6
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        // DP数组 状态 ：以下标结尾最长子元素个数  结尾一定是右括号
        int[] dp = new int[s.length()];
        for(int i = 1; i < s.length(); i++){
            // ) 结尾时统计
            if(s.charAt(i) == ')'){
                // 左边是 （ 直接计算最长个数  1、i-2个数 + 2   2、 0 + 2
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    // i - dp[i - 1] > 0  避免出现 i - dp[i - 1] = 0 情况导致越界
                }else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

}
