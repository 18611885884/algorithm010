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
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        int[][] res = new int[n][5];
        res[0][1] = -prices[0];
        res[1][1] = Math.max(res[0][1], -prices[1]);
        res[1][2] = res[0][1] + prices[1];
        for(int i = 2; i < n; i++){
            res[i][1] = Math.max(res[i - 1][1], -prices[i]);
            res[i][2] = Math.max(res[i - 1][1] + prices[i], res[i - 1][2]);
            res[i][3] = Math.max(res[i - 1][3], res[i - 1][2] - prices[i]);
            res[i][4] = Math.max(res[i - 1][3] + prices[i], res[i - 1][4]);
        }
        return Math.max(res[n - 1][2], res[n - 1][4]);
    }

    public static void main(String[] args) {
        new Test9().maxProfitIII(new int[]{1,2,3,4,5});
    }

}
