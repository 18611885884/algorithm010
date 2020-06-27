import java.util.ArrayList;
import java.util.List;

/**
 *    [78]子集
 *
 * @ClassName Subsets
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-27 22:52
 * @Version 1.0
 **/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null) return res;
        recur(res, 0, new ArrayList<Integer>(), nums);
        return res;
    }

    public void recur(List<List<Integer>> res, int i, List<Integer> integers, int[] nums) {
        if(i == nums.length){
            res.add(new ArrayList<Integer>(integers));
            return;
        }
        recur(res, i + 1, integers, nums);
        integers.add(nums[i]);
        recur(res, i + 1, integers, nums);
        integers.remove(integers.size() - 1);
    }

}
