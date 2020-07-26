import sun.corba.Bridge;

/**
 * 5. 最长回文子串
 * @ClassName LongestPalindrome
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-20 14:14
 * @Version 1.0
 **/
public class LongestPalindrome {

    /**
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     *
     * 输入: "cbbd"
     * 输出: "bb"
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        int maxLen = 1;
        int bigen = 0;
        int n = s.length();
        char[] sz = s.toCharArray();
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(j - i + 1 > maxLen && validPalindromic(sz, i, j)){
                    maxLen = j - i + 1;
                    bigen = i;
                }
            }
        }
        return s.substring(bigen, bigen + maxLen);
    }

    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private boolean validPalindromic(char[] sz, int i, int j) {
        while (i < j){
            if(sz[i++] != sz[j--]){
                return false;
            }
        }
        return true;
    }

}
