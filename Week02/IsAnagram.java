import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 *
 * @ClassName IsAnagram
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-20 14:11
 * @Version 1.0
 **/
public class IsAnagram {

    /**
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     */
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);

        return Arrays.equals(cs, ct);
    }

    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for(int cont:counter){
            if(cont != 0){
                return false;
            }
        }
        return true;
    }
}
