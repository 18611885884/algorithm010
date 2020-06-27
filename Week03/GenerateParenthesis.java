import java.util.ArrayList;
import java.util.List;

/**
 *    [22]括号生成
 *
 * @ClassName GenerateParenthesis
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-25 10:43
 * @Version 1.0
 **/
public class GenerateParenthesis {

    /**
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     */
    private List<String> result = new ArrayList<>();
    public void generateParenthesis(int n) {
        recur(2 * n,0, 0, "", n);
    }

    public void recur(int level, int left, int right, String param, int n) {
        // terminator 结束条件
        if (level == 0) {
            // process result
            result.add(param);
            System.out.println(param);
            return;
        }
        // process current logic 当前层级逻辑处理
        if(left < n){
            recur(level - 1, left + 1, right, param + "(", n);
        }
        if(right < left){
            recur(level - 1, left, right + 1, param + ")", n);
        }
        // restore current status 重置当前状态，全局变量值回复
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
}
