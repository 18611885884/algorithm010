/**
 * 221. 最大正方形
 * @ClassName MaximalSquare
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-19 22:19
 * @Version 1.0
 **/
public class MaximalSquare {
    /**
     * dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
     *
     * 状态 maxSide
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] res = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        res[i][j] = 1;
                    }else{
                        res[i][j] = Math.min(Math.min(res[i - 1][j], res[i][j - 1]), res[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, res[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
