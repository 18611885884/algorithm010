import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
        if (nums == null || nums.length == 0){
            return res;
        }
        permute(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }

    private void permute(List<List<Integer>> res, ArrayList<Integer> integers, int i, int[] nums) {
        if(i == nums.length){
            res.add(new ArrayList<>(integers));
            return;
        }
        for(int j = i; j < nums.length; j++){
            Collections.swap(integers, i, j);
            permute(res, integers, i + 1, nums);
            Collections.swap(integers, i, j);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1,2,3}));
    }
}
