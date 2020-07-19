/**
 * 1143. 最长公共子序列
 * @ClassName LongestCommonSubsequence
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-14 00:20
 * @Version 1.0
 **/
public class LongestCommonSubsequence {
    /**
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace"，它的长度为 3。
     *
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc"，它的长度为 3。
     *
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0){
            return 0;
        }
        int n = text1.length() + 1, m = text2.length() + 1;
        int[][] res = new int[n][m];
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(text1.charAt(i - 1) - text2.charAt(j - 1) == 0){
                    res[i][j] = res[i - 1][j - 1] + 1;
                }else{
                    res[i][j] = Math.max(res[i][j - 1], res[i - 1][j]);
                }
            }
        }
        return res[n][m];
    }
}
