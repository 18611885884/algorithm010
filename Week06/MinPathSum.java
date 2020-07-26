import java.util.HashMap;
import java.util.Map;

/**
 *    [64]最小路径和
 * @ClassName MinPathSum
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-20 10:27
 * @Version 1.0
 **/
public class MinPathSum {

    /**
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     */
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int n = grid.length, m = grid[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    res[i][j] = grid[i][j];
                }else if(i == 0){
                    res[i][j] = grid[i][j] + res[i][j - 1];
                }else if(j == 0){
                    res[i][j] = grid[i][j] + res[i - 1][j];
                }else{
                    res[i][j] = Math.min(res[i][j - 1], res[i - 1][j]) + grid[i][j];
                }
            }
        }
        return res[n - 1][m - 1];
    }

    public int minPathSum1(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j != 0){
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }else if(j == 0 && i != 0){
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }else if(j != 0 && i != 0){
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[n - 1][m - 1];
    }


}
