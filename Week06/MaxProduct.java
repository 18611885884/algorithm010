/**
 * 152. 乘积最大子数组
 * @ClassName MaxProduct
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-15 23:47
 * @Version 1.0
 **/
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int res = Integer.MIN_VALUE, min = 1, max = 1;
        for(int i = 0; i < nums.length; i++){
            int tem = max;
            max = Math.max(Math.max(tem * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tem * nums[i], min * nums[i]), nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
