/**
 * 198. 打家劫舍
 * @ClassName Rob
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-16 23:56
 * @Version 1.0
 **/
public class Rob {

    /**
     * 方法一  DP二维思想解决
     */
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[][] res = new int[n][2];
        // 二维标记偷与不偷  0 不偷  1 偷
        res[0][0] = 0;
        res[0][1] = nums[0];
        for(int i = 1; i < n; i++){
            // 当前层 不偷的值为上一层 偷或者不偷 的最大值
            res[i][0] = Math.max(res[i - 1][1], res[i - 1][0]);
            // 当前层 偷的值为 上一层不偷加本层的值
            res[i][1] = res[i - 1][0] + nums[i];
        }
        return Math.max(res[n - 1][0], res[n - 1][1]);
    }

    /**
     * 方法二  优化层一维数组
     * [2,1,1,2]
     */
    public int rob1(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        res[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < n; i++){
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
        }
        return res[n - 1];
    }

    /**
     * 方法三 状态定义再优化
     */
    public int rob2(int[] nums) {
        int a = 0, b = 0, c = 0;
        for(int i : nums){
            c = Math.max(a + i, b);
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        new Rob().rob(new int[]{1,2,3,1});
    }

}
