import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * @ClassName MinimumTotal
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-14 12:19
 * @Version 1.0
 **/
public class MinimumTotal {

    /**
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 方法一 递归 + 记忆化
     */
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return  dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * 方法二 迭代 DP 递推
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] sz = new int[n][n];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                if(i == n - 1 || j == n - 1){
                    sz[i][j] = triangle.get(i).get(j);
                    continue;
                }
                sz[i][j] = triangle.get(i).get(j) + Math.min(sz[i + 1][j], sz[i + 1][j + 1]);
            }
        }
        return sz[0][0];
    }

    /**
     * 方法三  空间优化
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> param = new ArrayList<>();
        System.out.println(new MinimumTotal().minimumTotal(param));
    }
}
