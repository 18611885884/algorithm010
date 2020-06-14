import java.util.*;

/**
 * 三数之和
 *
 * @ClassName ThreeSum
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-14 13:02
 * @Version 1.0
 **/
public class ThreeSum {

    /**
     * 两数之和 -- 双重for循环解法，hash解法后续补充
     */
    public int[] towSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 三数之和
     * 方法一 三重for循环，利用 HashSet 去重
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null && nums.length < 3){
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++){
                for (int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * 三数之和
     * 方法二 夹逼法
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        if(nums == null && nums.length < 3){
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            // 细节 最左边大于0 一定没有符合条件结果
            if(nums[i] > 0){
                break;
            }
            // 细节 排序后可避免最左边值重复情况
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                // 细节拉满 最左重复值跳过
                if(sum < 0){
                    while (j < k && nums[j] == nums[++j]);
                }else if(sum > 0){
                    // 最有重复值跳过
                    while (j < k && nums[k] == nums[--k]);
                }else{
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[++j]);
                    while (j < k && nums[k] == nums[--k]);
                }
            }
        }
        return result;
    }
}
