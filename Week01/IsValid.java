import java.util.*;

/**
 * 有效的括号
 *
 * @ClassName IsValid
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-14 21:38
 * @Version 1.0
 **/
public class IsValid {

    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))){
            return false;
        }
        Stack stack =  new Stack(){{push('1');}};
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            }else{
                char i = (char)stack.pop();
                if(c != map.get(i)){
                    return false;
                }
            }
        }
        return stack.size() == 1;
    }
}
