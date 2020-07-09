/**
 * 189. 旋转数组
 * @ClassName Rotate
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-08 22:18
 * @Version 1.0
 **/
public class Rotate {


    public void rotate(int[] nums, int k) {
        if(nums.length == 0){
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int str, int end){
        while (str < end){
            int ls = nums[end];
            nums[end--] = nums[str];
            nums[str++] = ls;
        }
    }
}
