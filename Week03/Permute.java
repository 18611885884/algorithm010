import java.util.ArrayList;
import java.util.List;

/**
 *    [46]全排列
 * @ClassName Permute
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-28 23:17
 * @Version 1.0
 **/
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, nums, new ArrayList<Integer>());
        return res;
    }

    private void permute(List<List<Integer>> res, int[] nums, ArrayList<Integer> integers) {
        if(integers.size() == nums.length){
            res.add(new ArrayList<>(integers));
            return;
        }
        for(int i:nums){
            if(integers.contains(i)) continue;
            integers.add(i);
            permute(res, nums, integers);
            integers.remove(integers.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1,2,3}));
    }
}
