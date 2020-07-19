/**
 *    [69]x 的平方根
 * @ClassName MySqrt
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-06 21:59
 * @Version 1.0
 **/
public class MySqrt {
    public int mySqrt(int x) {
        int i = 0, j = x, ans = -1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if((long)mid * mid <= x){
                i = mid + 1;
                ans = mid;
            }else{
                j = mid - 1;
            }
        }
        return ans;
    }
}
