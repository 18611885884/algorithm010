import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *    [51]N皇后
 *
 * @ClassName SolveNQueens
 * @Description
 * @Author luozhengqi
 * @Date 2020-06-29 14:15
 * @Version 1.0
 **/
public class SolveNQueens {
    public List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n == 0){
            return result;
        }
        Set<Integer> coun = new HashSet<>(-1);
        solveNQueens(result, new ArrayList<String>(), 1, 1, n, coun);
        return result;
    }

    private void solveNQueens(List<List<String>> result, ArrayList<String> strings, int row, int col, int n, Set<Integer> coun) {
        if(row == n){
            result.add(new ArrayList<>(strings));
            return;
        }
        for(; row <= n; row++){
            while (!check(coun, row++, col++) ){

            }
            String ss = "";
            for(int j = 0; j < n; j++){
                ss = row == j + 1 ? ss + "Q" : ss + "*";
            }
            strings.add(ss);
            solveNQueens(result, strings, row + 1, col + 1, n, coun);
            strings.remove(ss);
        }
    }

    private boolean check(Set<Integer> coun, int row, int col) {
        if(coun.contains(row - col)){

        }
        return false;
    }
}
