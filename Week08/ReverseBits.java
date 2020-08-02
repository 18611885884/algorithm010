/**
 * 190. 颠倒二进制位
 * @ClassName ReverseBits
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-29 22:51
 * @Version 1.0
 **/
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res = (res << 1) + (n & 1);
            n = n >> 1;
        }
        return res;
    }
}
