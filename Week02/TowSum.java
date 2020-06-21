import java.util.HashMap;
import java.util.Map;

/**
 * 两数求和 -- hash
 *
 * @ClassName TowSum
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-20 15:19
 * @Version 1.0
 **/
public class TowSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(target - nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && i != map.get(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }
        }
        return null;
    }

    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int res = target - nums[i];
            if(map.containsKey(res) && map.get(res) != i){
                return new int[]{map.get(res), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
