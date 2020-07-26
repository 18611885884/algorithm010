import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 37. 解数独
 * @ClassName SolveSudoku
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-26 21:08
 * @Version 1.0
 **/
public class SolveSudoku {
    /**
     * 方法一  剪枝 & 回溯  仿照 N皇后问题解答
     *
     * 可以优化的地方  41 行到 47 行
     * if(ind==81) return true;
     * int i=ind/9, j=ind%9, num, k;
     *
     * k= i/3*3 + j/3;
     */

    // 标记行、列、盒子被填充过的数字  9:0~8  10:1~9
    boolean[][] rows = new boolean[9][10];
    boolean[][] cols = new boolean[9][10];
    boolean[][] boxs = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        // 初始现有数字占用情况
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int bo = board[i][j] - '0';
                if(board[i][j] != '.'){
                    rows[i][bo] = true;
                    cols[j][bo] = true;
                    boxs[i / 3 * 3 + j / 3][bo] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int i, int j) {
        if(j == board[i].length){
            j = 0;
            i++;
            if(i == board.length){
                return true;
            }
        }
        if(board[i][j] == '.'){
            for(int k = 1; k <= 9; k++){
                if(!(rows[i][k] || cols[j][k] || boxs[i / 3 * 3 + j / 3][k])){
                    rows[i][k] = true;
                    cols[j][k] = true;
                    boxs[i / 3 * 3 + j / 3][k] = true;
                    board[i][j] = (char)('0' + k) ;
                    if(dfs(board, i, j + 1)){
                        return true;
                    }
                    rows[i][k] = false;
                    cols[j][k] = false;
                    boxs[i / 3 * 3 + j / 3][k] = false;
                    board[i][j] = '.' ;
                }
            }
            return false;
        }else {
            return dfs(board, i, j + 1);
        }
    }
}
