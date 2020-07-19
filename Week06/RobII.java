/**
 * 213. 打家劫舍 II
 * @ClassName RobII
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-17 00:34
 * @Version 1.0
 **/
public class RobII {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        // 偷第一个最大收益数组
        int[] dp = new int[n];
        int[] dp1 = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp1[0] = 0;
        dp1[1] = nums[1];
        for (int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        return Math.max(dp[n - 2], dp1[n - 1]);
    }
}
