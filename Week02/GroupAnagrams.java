import java.util.*;

/**
 * 字母异位词分组
 *
 * @ClassName GroupAnagrams
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-20 14:41
 * @Version 1.0
 **/
public class GroupAnagrams {

    /**
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0){
            return null;
        }
        Map<String, List> ans = new HashMap<>();
        for(String s:strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String so = new String(ch);
            if(!ans.containsKey(so)){
                ans.put(so, new ArrayList());
            }
            ans.get(so).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0){
            return null;
        }
        Map<String, List> ans = new HashMap<>();
        for(String s:strs){
            int[] zms = new int[26];
            for(char c:s.toCharArray()){
                zms[c - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < 26; i++){
                sb.append(zms[i]);
                sb.append("#");
            }
            String key = sb.toString();
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        String[] s = new String[]{"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams.groupAnagrams(s);
    }

}
