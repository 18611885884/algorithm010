/**
 * 300. 最长上升子序列
 * @ClassName LengthOfLIS
 * @Description
 * @Author luozhengqi
 * @Date 2020-08-18 17:58
 * @Version 1.0
 **/
public class LengthOfLIS {
    /**
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     *
     * [2,8,4,5,32]
     * [1,3,6,7,9,4,10,5,6]
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for(int i = 1; i < nums.length; i++){
            int maxVal = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        new LengthOfLIS().lengthOfLIS(new int[]{2,8,4,5,9});
    }
}
