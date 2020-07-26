/**
 * 72. 编辑距离
 * @ClassName MinDistance
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-20 18:05
 * @Version 1.0
 **/
public class MinDistance {
    /**
     * 看了题解有点类似 最大正方形解题思路
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

    public static void main(String[] args) {
        new MinDistance().minDistance("a", "ab");

    }
}
