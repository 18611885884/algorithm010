/**
 * 最长公共前缀
 *
 * @ClassName LongestCommonPrefix
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-15 12:14
 * @Version 1.0
 **/
public class LongestCommonPrefix {

    /**
     * 方法一
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null){
            return null;
        }
        char[] chars = strs[0].toCharArray();
        for(int i = 1; i < strs.length; i++){
            char[] chis = strs[i].toCharArray();
            for(int j = 0; j < chars.length && j < chis.length; j++){
                if(chars[j] != chis[j]){
                    chars = strs[0].substring(0, j).toCharArray();
                }
            }
        }
        return chars.toString();
    }
}
