import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test6
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-15 00:51
 * @Version 1.0
 **/
public class Test6 {
    /**
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     *
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0){
            return 0;
        }
        int n = triangle.size();
        int[] res = new int[n + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                res[j] = triangle.get(i).get(j) + Math.min(res[j], res[j + 1]);
            }
        }

        return res[0];
    }

    /**
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int sygVal = 0, resVal = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(sygVal > 0){
                sygVal = sygVal + nums[i];
            }else{
                sygVal = nums[i];
            }
            resVal = Math.max(resVal, sygVal);
        }
        return resVal;
    }

    /**
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     *
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for(int i = 0; i < nums.length; i++){
            int tem = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    /**
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     */
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int a = nums[0], b = Math.max(a, nums[1]), c = Math.max(a, b);
        for(int i = 2; i < nums.length; i++){
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 示例 1:
     *
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2:
     *
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     */
    public int robII(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int[] oneT = new int[n];
        int[] oneNo = new int[n];
        oneT[0] = nums[0];
        oneNo[0] = 0;
        oneT[1] = Math.max(nums[1], nums[0]);
        oneNo[1] = nums[1];
        for(int i = 2; i < n; i++){
            oneT[i] = Math.max(oneT[i - 1], oneT[i - 2] + nums[i]);
            oneNo[i] = Math.max(oneNo[i - 1], oneNo[i - 2] + nums[i]);
        }
        return Math.max(oneT[n - 2], oneNo[n - 1]);
    }

    public int maxProfitII(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int res = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i + 1] > prices[i]){
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Test6().rob(new int[]{1,2,3,1});
    }
}
