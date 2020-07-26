import java.util.*;

/**
 * 91. 解码方法
 * @ClassName NumDecodings
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-19 23:42
 * @Version 1.0
 **/
public class NumDecodings {
    /**
     * 解题思路  1、递归   和爬楼梯一题有些类似
     * 2、迭代 递推
     */
    Map<Integer, Integer> cache = new HashMap<>();
    public int numDecodings(String s) {
        return dfs(s, 0);
    }

    private int dfs(String s, int start) {
        if(s.length() == start){
            return 1;
        }
        if(s.charAt(start) == '0'){
            return 0;
        }
        if(cache.containsKey(start)){
            return cache.get(start);
        }
        int ans1 = dfs(s, start + 1);
        int ans2 = 0;
        if(start < s.length() - 1){
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if(ten + one <= 26){
                ans2 = dfs(s, start + 2);
            }
        }
        cache.put(start, ans1 + ans2);
        return ans1 + ans2;
    }

    public int numDecodings1(String s) {
        if(s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= n; i++){
            int first = Integer.parseInt(s.substring(i - 1, i));
            int last = Integer.parseInt(s.substring(i - 2, i));
            if(first >= 1 && first <= 9){
                dp[i] = dp[i - 1];
            }
            if(10 <= last && last <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
