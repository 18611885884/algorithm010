/**
 *    [剑指 Offer 49]丑数
 *
 * @ClassName NthUglyNumber
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-22 12:15
 * @Version 1.0
 **/
public class NthUglyNumber {

    /**
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     */
    public static int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            int ma = res[a] * 2, mb = res[b] * 3, mc = res[c] * 5;
            res[i] = Math.min(Math.min(ma, mb), mc);
            if(res[i] == ma){
                a++;
            }
            if(res[i] == mb){
                b++;
            }
            if(res[i] == mc){
                c++;
            }
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        NthUglyNumber.nthUglyNumber(10);
    }
}
