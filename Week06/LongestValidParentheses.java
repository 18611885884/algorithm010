/**
 *    [32]最长有效括号
 * @ClassName LongestValidParentheses
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-20 15:19
 * @Version 1.0
 **/
public class LongestValidParentheses {
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
