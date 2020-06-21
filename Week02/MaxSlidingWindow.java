import java.util.PriorityQueue;

/**
 * [剑指 Offer 59 - I]滑动窗口的最大值
 *
 * @ClassName MaxSlidingWindow
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-22 00:00
 * @Version 1.0
 **/
public class MaxSlidingWindow {

    /**
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < k || nums.length == 0){
            return new int[0];
        }
        PriorityQueue<Integer> ans = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for(int i = 0; i < len; i++){
            int start = i - k;
            if(start >= 0){
                ans.remove(nums[start]);
            }
            ans.offer(nums[i]);
            if(ans.size() == k){
                res[i + 1 - k] = ans.peek();
            }
        }
        return res;
    }
}
