import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *    [347]前 K 个高频元素
 *
 * @ClassName TopKFrequent
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-22 23:13
 * @Version 1.0
 **/
public class TopKFrequent {

    /**
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 输入: nums = [1], k = 1
     * 输出: [1]
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((k1, k2) -> map.get(k2) - map.get(k1));
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Integer i : map.keySet()){
            queue.add(i);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        return res;
    }
}
