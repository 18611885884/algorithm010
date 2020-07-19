/**
 * 63. 不同路径 II
 * @ClassName UniquePathsWithObstacles
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-13 23:41
 * @Version 1.0
 **/
public class UniquePathsWithObstacles {
    /**
     * 方法一 递推 O(n*m)
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null && obstacleGrid.length == 0){
            return 0;
        }
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] nums = new int[n][m];
        for(int i = 0; i < n && obstacleGrid[i][0] == 0; i++) nums[i][0] = 1;
        for(int i = 0; i < m && obstacleGrid[0][i] == 0; i++) nums[0][i] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(obstacleGrid[i][j] == 0) nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
