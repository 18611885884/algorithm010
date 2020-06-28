
/**
 *    [169]多数元素
 *
 * @ClassName MajorityElement
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-27 23:28
 * @Version 1.0
 **/
public class MajorityElement {

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int i = 0;
        for(int j = lo; j <= hi; j++){
            if(nums[j] == num){
                i++;
            }
        }
        return i;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        if(lo == hi) return nums[lo];
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);
        if(left == right) return left;
        int countLeft = countInRange(nums, left, lo, hi);
        int countRight = countInRange(nums, right, lo, hi);
        return countLeft > countRight ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3,2,3}));
    }
}
