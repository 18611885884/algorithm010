/**
 * 72. 编辑距离
 * @ClassName MinDistance
 * @Description
 * @Author luozhengqi
 * @Date 2020-08-18 17:16
 * @Version 1.0
 **/
public class MinDistance1 {
    /**
     * 示例 1：
     *
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2：
     *
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n * m == 0){
            return n + m;
        }
        int[][] res = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            res[i][0] = i;
        }
        for(int i = 1; i <= m; i++){
            res[0][i] = i;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int up = res[i - 1][j] + 1;
                int left = res[i][j - 1] + 1;
                int upLeft = res[i - 1][j - 1];
                if(word1.charAt(i - 1) != word2.charAt(j - 1)){
                    upLeft += 1;
                }
                res[i][j] = Math.min(Math.min(up, left), upLeft);
            }
        }
        return res[n][m];
    }
}
