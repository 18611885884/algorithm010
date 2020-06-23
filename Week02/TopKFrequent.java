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
        int[] res = new int[k];
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : nums){
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pri = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
        for(int i : count.keySet()){
            if(pri.size() < k){
                pri.add(i);
            }else{
                int j = pri.poll();
                if (count.get(j) > count.get(i)) {
                    pri.add(j);
                } else {
                    pri.add(i);
                }
            }
        }
        for(int i = 0; i < k; i++){
            res[i] = pri.poll();
        }
        return res;
    }
}
