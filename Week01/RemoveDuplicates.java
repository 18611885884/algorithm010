/**
 * 26. 删除排序数组中的重复项
 * @ClassName RemoveDuplicates
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-08 21:57
 * @Version 1.0
 **/
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[res]){
                res++;
                nums[res] = nums[i];
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicates(new int[]{1,1,2});
    }
}
