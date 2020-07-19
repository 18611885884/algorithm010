import java.util.*;

/**
 * @ClassName Test
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-20 10:45
 * @Version 1.0
 **/
public class Test2 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String ss:strs){
            char[] pl = new char[26];
            for(char i:ss.toCharArray()){
                pl[i - 'a']++;
            }
            String key = String.valueOf(pl);
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(ss);
        }
        return new ArrayList<>(map.values());
    }

    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 2){
            return new int[2];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else{
                map.put(target - nums[i], i);
            }
        }
        return new int[2];
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if(arr.length ==0 || k >= arr.length){
            return arr;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>( (o1, o2) -> o1 - o2);
        for(int i:arr){
            queue.add(i);
        }
        for(int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        return res;
    }

    ArrayDeque<Integer> index = new ArrayDeque<Integer>();
    // 大值在前，小值在后，小值会被放入队尾。小值在前大值在后在同一个窗口中，会移除小值，大值顶到队头
    public void clean_deque(int[] nums, int i, int k) {
        // 最大值下标等于窗口要移走值的下标  则在队头删除
        if(!index.isEmpty() && index.getFirst() == i - k){
            index.removeFirst();
        }
        // 下一窗口时 当前值比队尾值大 则移除对尾值， 2，3 存在 窗口不移除这个范围，最大的只能是 3
        while (!index.isEmpty() && nums[i] > nums[index.getLast()]) index.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k || nums .length == 0) return new int[0];
        if(k == 1) return nums;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // 前k个元素单独处理 方便clean_deque处理
        for(int i = 0; i < k; i++){
            clean_deque(nums, i, k);
            index.addLast(i);
        }
        res[0] = nums[index.getFirst()];
        // 大值小值都会加入队列，队列中（窗口中）大值前有小值，小值会被删除
        for(int i = k; i < n; i++){
            clean_deque(nums, i, k);
            index.addLast(i);
            res[i - k + 1] = nums[index.getFirst()];
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices.length < 2){
            return res;
        }
        maxProfit(res, false, true, false, prices, 0);
        return res;
    }

    private void maxProfit(int res, boolean ldq, boolean kymr, boolean kymc, int[] prices, int i) {
        if(i == prices.length){
            return;
        }
        if(ldq){
            return;
        }else{
            ldq = false;
        }
        int ls = res;
        if(kymr){
            ls = ls - prices[i];
        }
        i++;
    }

    /**
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     */
    public int nthUglyNumber(int n) {
        int[] common = new int[]{2, 3, 5};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        int res = 1;
        while (!queue.isEmpty()){
            long val = queue.poll();
            if(n == res){
               return (int)val;
            }
            for(int i:common){
                if(!queue.contains(i * val)){
                    queue.add(i * val);
                }
            }
            res++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Test2().nthUglyNumber(199));
    }
}
