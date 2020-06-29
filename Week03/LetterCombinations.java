import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *    [17]电话号码的字母组合
 *
 * @ClassName LetterCombinations
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-28 23:58
 * @Version 1.0
 **/
public class LetterCombinations {
    private Map<Character, String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return null;
        }
        List<String> result = new ArrayList<>();
        search(result, 0, "", digits);
        return result;
    }

    private void search(List<String> result, int i, String str, String digits) {
        if(i == digits.length()){
            result.add(str);
            return;
        }
        i++;
        char chNum = digits.charAt(i);
        for(char zm:map.keySet()){
            search(result, i, str + zm, digits);
        }
    }
}
