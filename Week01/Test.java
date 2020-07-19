import java.util.*;

/**
 * @ClassName Test
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-16 21:47
 * @Version 1.0
 **/
public class Test {


    public int maxArea(int[] height) {
        if(height.length < 2){
            return 0;
        }
        // 双指针求解
        int i = 0, j = height.length - 1;
        int maxAr = Integer.MIN_VALUE;
        // 求面积边不为0，i 不等于 j
        while (i < j){
            // 计算面积 取最较小的高
            int area = (j - i) * Math.min(height[i], height[j]);
            maxAr = Math.min(maxAr, area);
            // 移动较小高的边界
            if(height[i] < height[j]){
                i++;
            }else {
                j--;
            }
        }
        return maxAr;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3){
            return res;
        }
        // 保证有序（升序），才可使用双指针
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            // 完善代码调用， 第一个数大于0.则没有三个数相加为0
            if (nums[i] > 0) break;
            // 检验最做边指针重复性
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                // 使用while减少相邻值相等情况出现
                if(sum == 0){
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while (j < k && nums[j] == nums[++j]);
                    while (j < k && nums[k] == nums[--k]);
                }else if(sum < 0){
                    while (j < k && nums[j] == nums[++j]);
                }else{
                    while (j < k && nums[k] == nums[--k]);
                }
            }
        }

        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 返回链表
        ListNode pro = null;
        ListNode cur = head;

        while (cur != null) {
            // 注释仅为第一遍循环 链表状态变更 后续变更脑补
            // temp = 2->3->4->5
            ListNode temp = cur.next;
            // cur = 1->null
            cur.next = pro;
            // pro = 1->null
            pro = cur;
            // cur = 2->3->4->5
            cur = temp;
        }
        return pro;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 巧妙 创建第一个节点方便后续节点两两交换
        ListNode res = new ListNode(-1);
        res.next = head;
        // 指针指向地址值发生变化
        // 假设 -1 -> 1 -> 2 -> 3 -> 4 -> 5
        ListNode temp = res;
        while (temp.next != null && temp.next.next != null) {
            // start = 1 -> 2 -> 3 -> 4 -> 5
            // end = 2 -> 3 -> 4 -> 5
            ListNode start = temp.next, end = temp.next.next;
            // temp = -1 -> 2 -> 3 -> 4 -> 5
            temp.next = end;
            // start = 1 -> 3 -> 4 -> 5
            start.next = end.next;
            // end = 2 -> 1 -> 3 -> 4 -> 5
            end.next = start;
            // temp = 1 -> 3 -> 4 -> 5 类似开始的
            // -1 -> 1 -> 2 -> 3 -> 4 -> 5  第一个元素没有实际意义
            temp = start;
        }
        return res.next;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode m = head, k = head.next;
        while (k != null && k.next != null){
            if(m.val == k.val){
                return true;
            }
            m = m.next;
            k = k.next.next;
        }
        return false;
    }

    private static Map<Character, Character> khMap = new HashMap<Character, Character>(){{
        put('(', ')'); put('{', '}'); put('[', ']'); //put(" ", " ");
    }};
    public boolean isValid(String s) {
        if(s == null || s.length() % 2 == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(khMap.containsKey(c)){
                stack.add(c);
            }else{
                if(stack.isEmpty()) return false;
                char re = stack.pop();
                if(!khMap.get(re).equals(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    //public MinStack() {
    //    stack = new Stack();
    //    minStack = new Stack();
    //}

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.pop() == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        new Test().isValid("()");
    }
}
