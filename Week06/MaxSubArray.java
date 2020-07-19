/**
 * 53. 最大子序和
 * @ClassName MaxSubArray
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-15 22:43
 * @Version 1.0
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // 全局最大值
        int res = nums[0];
        // 上一步最大值
        int sum = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(sum >= 0){
                sum = sum + nums[i];
            }else{
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        return maxSubArrayDivideWithBorder(nums, 0, nums.length-1);
    }

    private int maxSubArrayDivideWithBorder(int[] nums, int start, int end) {
        if (start == end) {
            // 只有一个元素，也就是递归的结束情况
            return nums[start];
        }

        // 计算中间值
        int center = (start + end) / 2;
        int leftMax = maxSubArrayDivideWithBorder(nums, start, center); // 计算左侧子序列最大值
        int rightMax = maxSubArrayDivideWithBorder(nums, center + 1, end); // 计算右侧子序列最大值

        // 下面计算横跨两个子序列的最大值

        // 计算包含左侧子序列最后一个元素的子序列最大值
        int leftCrossMax = Integer.MIN_VALUE; // 初始化一个值
        int leftCrossSum = 0;
        for (int i = center ; i >= start ; i --) {
            leftCrossSum += nums[i];
            leftCrossMax = Math.max(leftCrossSum, leftCrossMax);
        }

        // 计算包含右侧子序列最后一个元素的子序列最大值
        int rightCrossMax = nums[center+1];
        int rightCrossSum = 0;
        for (int i = center + 1; i <= end ; i ++) {
            rightCrossSum += nums[i];
            rightCrossMax = Math.max(rightCrossSum, rightCrossMax);
        }

        // 计算跨中心的子序列的最大值
        int crossMax = leftCrossMax + rightCrossMax;

        // 比较三者，返回最大值
        return Math.max(crossMax, Math.max(leftMax, rightMax));
    }
}
