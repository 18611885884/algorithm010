/**
 *    [50]Pow(x, n)
 *
 * @ClassName MyPow
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-26 21:30
 * @Version 1.0
 **/
public class MyPow {
    /**
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     *
     * 输入: 2.10000, 3
     * 输出: 9.26100
     *
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     *
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1]
     */
    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? quickMul(x, N) : 1.0 / quickMul(x , -N);
    }

    private double quickMul(double x, long n) {
        if(n == 0){
            return 1.0;
        }
        double j = quickMul(x, n / 2);
        return n % 2 == 1 ? j * j * x : j * j;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2, -10));
    }
}
