/**
 *    [367]有效的完全平方数
 * @ClassName IsPerfectSquare
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-06 22:21
 * @Version 1.0
 **/
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int i = 0, j = num;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if((long)mid * mid == num){
                return true;
            }else if((long)mid * mid < num){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return false;
    }


}
