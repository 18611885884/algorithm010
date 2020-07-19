import java.util.Arrays;

/**
 *    [62]不同路径
 * @ClassName UniquePaths
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-13 21:15
 * @Version 1.0
 **/
public class UniquePaths {
    /**
     * 方法一 递归自上向下  运行超时 O(2^n)
     **/
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return 1;
        }
        return uniquePaths(0 , 0, new int[m][n]);
    }

    private int uniquePaths(int row, int col, int[][] sz) {
        if(sz.length - 1 == row && sz[0].length - 1 == col){
            return 1;
        }
        if(sz[row][col] != 0){
            return sz[row][col];
        }
        int rightPaths = 0;
        if(row + 1 < sz.length){
            rightPaths = uniquePaths(row + 1, col, sz);
        }
        int downPaths = 0;
        if(col + 1 < sz[0].length){
            downPaths = uniquePaths(row, col + 1, sz);
        }
        return rightPaths + downPaths;
    }

    /**
     * 方法二 递推（）迭代
     **/
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 方法三 方法二优化代码， O(n)
     */
    public int uniquePaths2(int m, int n) {
        int[] sz = new int[n];
        Arrays.fill(sz, 1);
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                sz[j] += sz[j - 1];
            }
        }
        return sz[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths1(3, 2));
    }
}
