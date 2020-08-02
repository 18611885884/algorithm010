/**
 * 231. 2的幂
 * @ClassName IsPowerOfTwo
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-29 22:38
 * @Version 1.0
 **/
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        n = n & (n - 1);
        return n == 0;
    }
}
