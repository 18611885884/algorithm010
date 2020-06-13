/**
 * 移动零
 *
 * @ClassName MoveZeroes
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-13 23:56
 * @Version 1.0
 **/
public class MoveZeroes {

    /**
     * 方法一 暴力解法 两个循环
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums.length <= 0) {
            return ;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    /**
     * 方法二 双指针 叫快慢指针更为具体
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */
    public void moveZeroes1(int[] nums) {
        if (nums.length <= 0) {
            return ;
        }
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if(i > j){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                j++;
            }
        }
    }
}
