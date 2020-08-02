/**
 * 191. 位1的个数
 * @ClassName HammingWeight
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-29 22:31
 * @Version 1.0
 **/
public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
