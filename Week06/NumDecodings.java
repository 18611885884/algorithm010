import java.util.*;

/**
 * 91. 解码方法
 * @ClassName NumDecodings
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-19 23:42
 * @Version 1.0
 **/
public class NumDecodings {
    /**
     * 解题思路  1、递归   和爬楼梯一题有些类似
     * 2、迭代 递推
     */
    Map<Integer, Integer> cache = new HashMap<>();
    public int numDecodings(String s) {
        return dfs(s, 0);
    }

    private int dfs(String s, int start) {
        if(s.length() == start){
            return 1;
        }
        if(s.charAt(start) == '0'){
            return 0;
        }
        if(cache.containsKey(start)){
            return cache.get(start);
        }
        int ans1 = dfs(s, start + 1);
        int ans2 = 0;
        if(start < s.length() - 1){
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if(ten + one <= 26){
                ans2 = dfs(s, start + 2);
            }
        }
        cache.put(start, ans1 + ans2);
        return ans1 + ans2;
    }
}
