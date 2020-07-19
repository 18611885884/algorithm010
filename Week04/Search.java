/**
 *    [33]搜索旋转排序数组
 * @ClassName Search
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-06 22:25
 * @Version 1.0
 **/
public class Search {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[i] <= nums[mid]) {
                if(nums[mid] > target && nums[i] <= target){
                    j = mid - 1;
                }else{
                    i = mid + 1;
                }
            }else{
                if(nums[mid] < target && nums[j] >= target){
                    i = mid + 1;
                }else{
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Search().search(new int[]{4,5,6,7,0,1,2}, 0);
    }
}
