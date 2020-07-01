import java.util.ArrayList;
import java.util.List;

/**
 *    [77]组合
 *
 * @ClassName Combine
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-30 21:21
 * @Version 1.0
 **/
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, 1, n, k, new ArrayList<Integer>());
        return result;
    }

    private void combine(List<List<Integer>> result, int fa, int n, int k, List<Integer> coms) {
        if(coms.size() == k){
            result.add(new ArrayList<>(coms));
            return;
        }
        for(int i = fa; i <= n; i++){
            coms.add(i);
            combine(result, ++fa, n, k, coms);
            coms.remove(coms.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
