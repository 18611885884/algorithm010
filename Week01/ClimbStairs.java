/**
 * 爬楼梯
 *
 * @ClassName ClimbStairs
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-14 12:21
 * @Version 1.0
 **/
public class ClimbStairs {

    /**
     * 解题思路：上n阶台阶，必然是从 n-1 或者 n-2 上来
     * 方法一：递归 需要配合缓存使用
     */
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        return climbStairs(n -1) + climbStairs(n - 2);
    }

    /**
     * 方法二
     */
    public int climbStairs1(int n) {
        if(n <= 2){
            return n;
        }
        int a = 1, b = 2, c = 3;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
